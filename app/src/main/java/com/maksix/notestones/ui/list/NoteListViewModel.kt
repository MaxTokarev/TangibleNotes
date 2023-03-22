package com.maksix.notestones.ui.list

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksix.notestones.common.ui.State
import com.maksix.notestones.domain.usecases.notes.observe.IObserveNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val observeNotesUseCase: IObserveNotesUseCase,
    private val resources: Resources
) : ViewModel() {

    private val _uiState = MutableStateFlow<State>(State.Loading)
    val uiState: StateFlow<State> get() = _uiState

    init {
        viewModelScope.launch(IO) {
            observeNotesUseCase.execute()
                .catch {  }
                .map { notes ->
                    notes.map { note ->
                        val text = buildString {
                            append(note.title)
                            appendLine()
                            append(note.description)
                        }
                        Log.d("TAG", "$text: ")
                        NoteListSmallItem(note.id, text, note.createdAt, getColor(note.backgroundColor))
                    }
                }
                .collect {
                    Log.d("TAG", "setupList: $it")
                    if (it.isEmpty()) {
                        _uiState.emit(State.Empty)
                    } else {
                        _uiState.emit(State.Main(it))
                    }
                }
        }
    }

    private fun getColor(colorId: Int): Int {
        return resources.getColor(colorId)
    }

}

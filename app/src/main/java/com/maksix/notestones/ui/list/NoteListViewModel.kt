package com.maksix.notestones.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksix.notestones.common.ui.State
import com.maksix.notestones.domain.usecases.notes.observe.ObserveNotesUseCase
import com.maksix.notestones.domain.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

private const val TAG = "NoteListViewModel"

@HiltViewModel
class NoteListViewModel @Inject constructor(
    observeNotesUseCase: ObserveNotesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<State>(State.Loading)
    val uiState: StateFlow<State> get() = _uiState.asStateFlow()

    init {
        observeNotesUseCase.execute()
            .catch { Log.e(TAG, "Failed to observe notes", it) }
            .map { notes -> notes.map(::toUi) }
            .onEach { notes ->
                val state = if (notes.isEmpty()) State.Empty else State.Content(notes)
                _uiState.tryEmit(state)
            }
            .flowOn(Dispatchers.Default)
            .launchIn(viewModelScope)
    }

    private fun toUi(note: Note) = NoteListSmallItem(
        id = note.id,
        text = note.title,
        createdAt = note.createdAt,
        backgroundColor = note.backgroundColor
    )
}

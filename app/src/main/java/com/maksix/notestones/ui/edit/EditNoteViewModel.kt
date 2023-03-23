package com.maksix.notestones.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksix.notestones.R
import com.maksix.notestones.domain.usecases.notes.get.GetNoteUseCase
import com.maksix.notestones.domain.usecases.notes.update.UpdateNoteUseCase
import com.maksix.notestones.domain.model.Note
import com.maksix.notestones.ui.add.AddNoteViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class EditNoteViewModel @AssistedInject constructor(
    @Assisted private val noteId: Int,
    private val getNoteUseCase: GetNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : ViewModel() {

    private val _note = MutableStateFlow<Note?>(null)
    val note get() = _note.filterNotNull()

    private val _uiEvents = Channel<AddNoteViewModel.Event>(Channel.BUFFERED)
    val uiEvent get() = _uiEvents.receiveAsFlow()

    init {
        setupNote()
    }

    private fun setupNote() {
        viewModelScope.launch(Dispatchers.IO) {
            if (noteId != -1) {
                getNoteUseCase.execute(noteId)
                    .collect { _note.emit(it) }
            }
        }
    }

    fun onSaveClicked(title: String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (title.isBlank() || description.isBlank()) {
                _uiEvents.send(AddNoteViewModel.Event.Error("Please fill one of the fields"))
            } else {
                updateNoteUseCase.execute(
                    Note(
                        id = noteId,
                        title = title,
                        description = description,
                        backgroundColor = getRandomColor()
                    )
                )
                _uiEvents.send(AddNoteViewModel.Event.SuccessfullyAdded)
            }
        }
    }

    private fun getRandomColor(): Int {
        return listOf(
            R.color.carissma,
            R.color.primrose,
            R.color.petite_orchid,
            R.color.spray,
            R.color.light_wisteria
        ).random()
    }

    @AssistedFactory
    interface Factory {
        fun create(noteId: Int): EditNoteViewModel
    }
}

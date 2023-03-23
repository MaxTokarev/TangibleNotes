package com.maksix.notestones.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksix.notestones.domain.usecases.notes.get.GetNoteUseCase
import com.maksix.notestones.domain.model.Note
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class NoteDetailViewModel @AssistedInject constructor(
    @Assisted private val noteId: Int,
    private val useCase: GetNoteUseCase
) : ViewModel() {

    private val _note = MutableStateFlow<Note?>(null)
    val note get() = _note.filterNotNull()

    init {
        setupNotes()
    }

    private fun setupNotes() {
        viewModelScope.launch {
            useCase.execute(noteId)
                .collect { _note.emit(it) }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(noteId: Int): NoteDetailViewModel
    }
}

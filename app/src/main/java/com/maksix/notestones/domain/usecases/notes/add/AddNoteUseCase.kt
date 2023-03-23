package com.maksix.notestones.domain.usecases.notes.add

import com.maksix.notestones.common.domain.usecases.BaseUseCase
import com.maksix.notestones.domain.repositories.NoteRepository
import com.maksix.notestones.domain.model.Note
import javax.inject.Inject

interface AddNoteUseCase : BaseUseCase.SingleIn<Note>

class AddNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
): AddNoteUseCase {
    override suspend fun execute(data: Note) {
        repository.addNote(data)
    }
}

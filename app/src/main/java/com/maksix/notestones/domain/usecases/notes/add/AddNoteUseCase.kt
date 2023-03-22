package com.maksix.notestones.domain.usecases.notes.add

import com.maksix.notestones.domain.repositories.INoteRepository
import com.maksix.notestones.models.domain.Note
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val repository: INoteRepository
): IAddNoteUseCase {
    override suspend fun execute(data: Note) {
        repository.addNote(data)
    }
}
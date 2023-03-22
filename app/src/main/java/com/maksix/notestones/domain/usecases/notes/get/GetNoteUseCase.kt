package com.maksix.notestones.domain.usecases.notes.get

import com.maksix.notestones.domain.repositories.INoteRepository
import com.maksix.notestones.models.domain.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNoteUseCase @Inject constructor(
    private val repository: INoteRepository
): IGetNoteUseCase {
    override suspend fun execute(data: Int): Flow<Note> {
        return repository.getNoteById(data)
    }
}
package com.maksix.notestones.domain.usecases.notes.get

import com.maksix.notestones.common.domain.usecases.BaseUseCase
import com.maksix.notestones.domain.repositories.NoteRepository
import com.maksix.notestones.domain.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetNoteUseCase : BaseUseCase.SingleFlowInOut<Int, Note>

class GetNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
): GetNoteUseCase {
    override suspend fun execute(data: Int): Flow<Note> {
        return repository.getNoteById(data)
    }
}

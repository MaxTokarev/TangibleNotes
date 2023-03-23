package com.maksix.notestones.domain.usecases.notes.observe

import com.maksix.notestones.common.domain.usecases.BaseUseCase
import com.maksix.notestones.domain.repositories.NoteRepository
import com.maksix.notestones.domain.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ObserveNotesUseCase: BaseUseCase.FlowOutList<Note>

class ObserveNotesUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository
) : ObserveNotesUseCase {
    override fun execute(): Flow<List<Note>> {
        return noteRepository.observeNotes()
    }
}

package com.maksix.notestones.domain.usecases.notes.observe

import com.maksix.notestones.domain.repositories.INoteRepository
import com.maksix.notestones.models.domain.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ObserveNotesUseCase @Inject constructor(
    private val noteRepository: INoteRepository
) : IObserveNotesUseCase {
    override fun execute(): Flow<List<Note>> {
        return noteRepository.observeNotes()
    }
}
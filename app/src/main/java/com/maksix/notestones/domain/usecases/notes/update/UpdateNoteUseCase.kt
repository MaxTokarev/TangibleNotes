package com.maksix.notestones.domain.usecases.notes.update

import com.maksix.notestones.domain.repositories.INoteRepository
import com.maksix.notestones.models.domain.Note
import com.maksix.notestones.models.entity.NoteEntity
import org.threeten.bp.OffsetDateTime
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val repository: INoteRepository
): IUpdateNoteUseCase {
    override suspend fun execute(data: Note) {
        val entity = NoteEntity(data.id, OffsetDateTime.now(), data.title, data.description, data.backgroundColor)
        repository.updateNote(entity)
    }
}
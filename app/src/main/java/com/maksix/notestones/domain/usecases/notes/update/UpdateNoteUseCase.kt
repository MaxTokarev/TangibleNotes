package com.maksix.notestones.domain.usecases.notes.update

import com.maksix.notestones.common.domain.usecases.BaseUseCase
import com.maksix.notestones.domain.repositories.NoteRepository
import com.maksix.notestones.domain.model.Note
import com.maksix.notestones.common.entity.NoteEntity
import org.threeten.bp.OffsetDateTime
import javax.inject.Inject

interface UpdateNoteUseCase : BaseUseCase.SingleIn<Note>

class UpdateNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
): UpdateNoteUseCase {
    override suspend fun execute(data: Note) {
        val entity = NoteEntity(data.id, OffsetDateTime.now(), data.title, data.description, data.backgroundColor)
        repository.updateNote(entity)
    }
}

package com.maksix.notestones.data.local

import com.maksix.notestones.data.db.note_list.NoteListDao
import com.maksix.notestones.models.entity.NoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

class NoteLocalDataSource @Inject constructor(
    private val notesDao: NoteListDao
) : INotesLocalDataSource {
    override fun observeNotes(): Flow<List<NoteEntity>> {
        return notesDao.observeNotes().distinctUntilChanged()
    }

    override suspend fun addNote(note: NoteEntity) {
        notesDao.insertNote(note)
    }

    override fun getNoteById(noteId: Int): Flow<NoteEntity> {
        return notesDao.getFlowById(noteId).distinctUntilChanged{ noteEntity: NoteEntity, noteEntity1: NoteEntity ->
            false
        }
    }

    override suspend fun updateNote(note: NoteEntity) {
        notesDao.update(note)
    }
}
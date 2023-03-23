package com.maksix.notestones.data.local

import com.maksix.notestones.data.db.notes.NoteListDao
import com.maksix.notestones.common.entity.NoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

class NotesLocalDataSourceImpl @Inject constructor(
    private val notesDao: NoteListDao
) : NotesLocalDataSource {
    override fun observeNotes(): Flow<List<NoteEntity>> {
        return notesDao.observeNotes().distinctUntilChanged()
    }

    override suspend fun addNote(note: NoteEntity) {
        notesDao.insertNote(note)
    }

    override fun getNoteById(noteId: Int): Flow<NoteEntity> {
        return notesDao.getFlowById(noteId)
    }

    override suspend fun updateNote(note: NoteEntity) {
        notesDao.update(note)
    }
}

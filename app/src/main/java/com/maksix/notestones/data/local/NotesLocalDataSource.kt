package com.maksix.notestones.data.local

import com.maksix.notestones.common.data.BaseLocalDataSource
import com.maksix.notestones.common.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NotesLocalDataSource: BaseLocalDataSource {
    fun observeNotes(): Flow<List<NoteEntity>>

    suspend fun addNote(note: NoteEntity)

    fun getNoteById(noteId:Int): Flow<NoteEntity>

    suspend fun updateNote(note: NoteEntity)
}

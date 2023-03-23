package com.maksix.notestones.domain.repositories

import com.maksix.notestones.common.domain.repository.BaseLocalRepository
import com.maksix.notestones.data.local.NotesLocalDataSource
import com.maksix.notestones.domain.model.Note
import com.maksix.notestones.common.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository : BaseLocalRepository<NotesLocalDataSource>{
    fun observeNotes(): Flow<List<Note>>

    suspend fun addNote(note: Note)

    suspend fun getNoteById(noteId: Int): Flow<Note>

    suspend fun updateNote(note: NoteEntity)
}

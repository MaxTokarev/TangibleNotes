package com.maksix.notestones.domain.repositories

import com.maksix.notestones.common.domain.repository.BaseLocalRepository
import com.maksix.notestones.common.domain.repository.BaseRepository
import com.maksix.notestones.data.local.INotesLocalDataSource
import com.maksix.notestones.models.domain.Note
import com.maksix.notestones.models.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

interface INoteRepository : BaseLocalRepository<INotesLocalDataSource>{
    fun observeNotes(): Flow<List<Note>>

    suspend fun addNote(note: Note)

    suspend fun getNoteById(noteId: Int): Flow<Note>

    suspend fun updateNote(note:NoteEntity)
}
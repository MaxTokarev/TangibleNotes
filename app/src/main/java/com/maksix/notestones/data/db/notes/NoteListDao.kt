package com.maksix.notestones.data.db.notes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maksix.notestones.common.data.BaseDao
import com.maksix.notestones.common.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteListDao : BaseDao<NoteEntity> {

    @Query("SELECT * FROM note_list ORDER BY createdAt DESC ")
    fun observeNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM note_list WHERE id = :id")
    fun getFlowById(id: Int): Flow<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)
}

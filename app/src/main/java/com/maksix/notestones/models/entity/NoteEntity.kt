package com.maksix.notestones.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.OffsetDateTime

@Entity(tableName = "note_list")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val createdAt: OffsetDateTime,
    val title: String,
    val description: String,
    val backgroundColor: Int
)
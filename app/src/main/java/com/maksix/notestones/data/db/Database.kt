package com.maksix.notestones.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.maksix.notestones.data.db.converters.OffsetDateTimeConverter
import com.maksix.notestones.data.db.note_list.NoteListDao
import com.maksix.notestones.models.entity.NoteEntity

@Database(
    entities = [
        NoteEntity::class
    ],
    exportSchema = true,
    version = 2
)
@TypeConverters(OffsetDateTimeConverter::class)
abstract class Database : RoomDatabase() {
    abstract fun getNoteListDao(): NoteListDao
}
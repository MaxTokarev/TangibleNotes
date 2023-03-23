package com.maksix.notestones.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.maksix.notestones.data.db.converters.OffsetDateTimeConverter
import com.maksix.notestones.data.db.notes.NoteListDao
import com.maksix.notestones.common.entity.NoteEntity

@Database(
    entities = [
        NoteEntity::class
    ],
    exportSchema = true,
    version = 2
)
@TypeConverters(OffsetDateTimeConverter::class)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun getNoteListDao(): NoteListDao
}

package com.maksix.notestones.di

import android.content.Context
import androidx.room.Room
import com.maksix.notestones.data.db.NotesDatabase
import com.maksix.notestones.data.db.notes.NoteListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DdModule {
    @Provides
    @Singleton
    fun bindDatabase(@ApplicationContext context: Context): NotesDatabase {
        return Room.databaseBuilder(context, NotesDatabase::class.java, "notes-app.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun bindNotesListDao(notesDatabase: NotesDatabase): NoteListDao {
        return notesDatabase.getNoteListDao()
    }
}

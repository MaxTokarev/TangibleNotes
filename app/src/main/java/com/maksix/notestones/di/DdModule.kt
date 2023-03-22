package com.maksix.notestones.di

import android.content.Context
import androidx.room.Room
import com.maksix.notestones.data.db.Database
import com.maksix.notestones.data.db.note_list.NoteListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DdModule {
    @Provides
    @Singleton
    fun bindDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, "notes-app.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun bindNotesListDao(database: Database): NoteListDao {
        return database.getNoteListDao()
    }
}
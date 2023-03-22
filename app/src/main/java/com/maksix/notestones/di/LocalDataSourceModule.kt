package com.maksix.notestones.di

import com.maksix.notestones.data.local.INotesLocalDataSource
import com.maksix.notestones.data.local.NoteLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindNoteDataSource(source: NoteLocalDataSource): INotesLocalDataSource
}
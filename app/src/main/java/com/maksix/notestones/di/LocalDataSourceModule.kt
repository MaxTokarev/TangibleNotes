package com.maksix.notestones.di

import com.maksix.notestones.data.local.NotesLocalDataSource
import com.maksix.notestones.data.local.NotesLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindNoteDataSource(source: NotesLocalDataSourceImpl): NotesLocalDataSource
}

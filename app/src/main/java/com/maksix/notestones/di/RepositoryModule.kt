package com.maksix.notestones.di

import com.maksix.notestones.data.repository.NoteRepositoryImpl
import com.maksix.notestones.domain.repositories.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindNoteRepository(repository: NoteRepositoryImpl): NoteRepository
}

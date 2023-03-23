package com.maksix.notestones.di

import com.maksix.notestones.domain.usecases.notes.add.AddNoteUseCase
import com.maksix.notestones.domain.usecases.notes.add.AddNoteUseCaseImpl
import com.maksix.notestones.domain.usecases.notes.get.GetNoteUseCase
import com.maksix.notestones.domain.usecases.notes.get.GetNoteUseCaseImpl
import com.maksix.notestones.domain.usecases.notes.observe.ObserveNotesUseCase
import com.maksix.notestones.domain.usecases.notes.observe.ObserveNotesUseCaseImpl
import com.maksix.notestones.domain.usecases.notes.update.UpdateNoteUseCase
import com.maksix.notestones.domain.usecases.notes.update.UpdateNoteUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindObserveNotesUseCase(useCase: ObserveNotesUseCaseImpl): ObserveNotesUseCase

    @Binds
    abstract fun bindAddNoteUseCase(useCase: AddNoteUseCaseImpl): AddNoteUseCase

    @Binds
    abstract fun bindGetNoteUseCase(useCase: GetNoteUseCaseImpl): GetNoteUseCase

    @Binds
    abstract fun binUpdateNoteUseCase(useCase: UpdateNoteUseCaseImpl): UpdateNoteUseCase
}

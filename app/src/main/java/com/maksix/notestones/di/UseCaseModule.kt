package com.maksix.notestones.di

import com.maksix.notestones.domain.usecases.notes.add.AddNoteUseCase
import com.maksix.notestones.domain.usecases.notes.add.IAddNoteUseCase
import com.maksix.notestones.domain.usecases.notes.get.GetNoteUseCase
import com.maksix.notestones.domain.usecases.notes.get.IGetNoteUseCase
import com.maksix.notestones.domain.usecases.notes.observe.IObserveNotesUseCase
import com.maksix.notestones.domain.usecases.notes.observe.ObserveNotesUseCase
import com.maksix.notestones.domain.usecases.notes.update.IUpdateNoteUseCase
import com.maksix.notestones.domain.usecases.notes.update.UpdateNoteUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindObserveNotesUseCase(useCase: ObserveNotesUseCase): IObserveNotesUseCase

    @Binds
    abstract fun bindAddNoteUseCase(useCase: AddNoteUseCase): IAddNoteUseCase

    @Binds
    abstract fun bindGetNoteUseCase(useCase: GetNoteUseCase): IGetNoteUseCase

    @Binds
    abstract fun binUpdateNoteUseCase(useCase: UpdateNoteUseCase): IUpdateNoteUseCase
}
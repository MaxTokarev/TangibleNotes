package com.maksix.notestones.domain.usecases.notes.observe

import com.maksix.notestones.common.domain.usecases.BaseUseCase
import com.maksix.notestones.models.domain.Note

interface IObserveNotesUseCase: BaseUseCase.FlowOutList<Note>
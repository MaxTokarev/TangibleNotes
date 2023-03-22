package com.maksix.notestones.domain.usecases.notes.add

import com.maksix.notestones.common.domain.usecases.BaseUseCase
import com.maksix.notestones.models.domain.Note

interface IAddNoteUseCase : BaseUseCase.SingleIn<Note>
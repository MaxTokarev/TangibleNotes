package com.maksix.notestones.domain.usecases.notes.update

import com.maksix.notestones.common.domain.usecases.BaseUseCase
import com.maksix.notestones.models.domain.Note

interface IUpdateNoteUseCase : BaseUseCase.SingleIn<Note>
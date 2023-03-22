package com.maksix.notestones.domain.usecases.notes.get

import com.maksix.notestones.common.domain.usecases.BaseUseCase
import com.maksix.notestones.models.domain.Note

interface IGetNoteUseCase : BaseUseCase.SingleFlowInOut<Int, Note>
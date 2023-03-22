package com.maksix.notestones.common.domain.usecases

import kotlinx.coroutines.flow.Flow


interface BaseUseCase {
    interface SingleIn<in Input> : BaseUseCase {
        suspend fun execute(data: Input)
    }

    interface DoubleInOut<in FirstInput, in SecondInput, out Output> : BaseUseCase {
        suspend fun execute(firstParam: FirstInput, secondParam: SecondInput): Output
    }

    interface SingleInOut<in Input, out Output> : BaseUseCase {
        suspend fun execute(data: Input): Output
    }

    interface SingleInOutList<in Input, out Output> : BaseUseCase {
        suspend fun execute(data: Input): List<Output>
    }

    interface SingleFlowInOut<in Input, out Output> : BaseUseCase {
        suspend fun execute(data: Input): Flow<Output>
    }

    interface SingleFlowInOutList<in Input, out Output> : BaseUseCase {
        suspend fun execute(data: Input): Flow<List<Output>>
    }

    interface Out<out Output> : BaseUseCase {
        suspend fun execute(): Output
    }

    interface OutList<out Output> : BaseUseCase {
        suspend fun execute(): List<Output>
    }

    interface FlowOutList<out Output> : BaseUseCase {
        fun execute(): Flow<List<Output>>
    }
}
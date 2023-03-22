package com.maksix.notestones.common.domain.repository

import com.maksix.notestones.common.data.BaseLocalDataSource

interface BaseLocalRepository<out Local: BaseLocalDataSource> {
    val localDataSource: Local
}
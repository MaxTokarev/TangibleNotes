package com.maksix.notestones.common.domain.repository

import com.maksix.notestones.common.data.BaseLocalDataSource
import com.maksix.notestones.common.data.BaseRemoteDataSource

interface BaseRepository<out Local : BaseLocalDataSource, out Remote : BaseRemoteDataSource> :
    BaseLocalRepository<Local>, BaseRemoteRepository<Remote>
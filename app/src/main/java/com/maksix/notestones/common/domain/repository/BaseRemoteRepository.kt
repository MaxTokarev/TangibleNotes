package com.maksix.notestones.common.domain.repository

import com.maksix.notestones.common.data.BaseRemoteDataSource

interface BaseRemoteRepository <out Remote: BaseRemoteDataSource> {
    val remoteDataSource: Remote
}
package com.maksix.notestones.common.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAll(entities: List<T>): Int

    @Insert
    suspend fun insert(entity: T): Long

    @Insert
    suspend fun insert(entities: List<T>): List<Long>

    @Update
    suspend fun update(entity: T)

    @Delete
    suspend fun delete(entity: T)
}
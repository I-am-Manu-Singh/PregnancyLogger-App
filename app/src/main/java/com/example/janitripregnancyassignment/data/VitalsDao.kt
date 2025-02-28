package com.example.janitripregnancyassignment.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVitals(vitals: VitalsEntity)

    @Query("SELECT * FROM vitals ORDER BY createdAt DESC")
    fun getAllVitals(): Flow<List<VitalsEntity>>

    @Delete
    suspend fun deleteVitals(vitals: VitalsEntity)
}
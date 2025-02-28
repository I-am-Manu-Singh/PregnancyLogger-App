package com.example.janitripregnancyassignment.db
import com.example.janitripregnancyassignment.data.VitalsDao
import com.example.janitripregnancyassignment.data.VitalsEntity
import kotlinx.coroutines.flow.Flow

class VitalsRepository(private val dao: VitalsDao) {
    val allVitals: Flow<List<VitalsEntity>> = dao.getAllVitals()


    suspend fun insertVitals(vitals: VitalsEntity) {
        dao.insertVitals(vitals)
    }


    suspend fun deleteVitals(vitals: VitalsEntity) {
        dao.deleteVitals(vitals)
    }
}
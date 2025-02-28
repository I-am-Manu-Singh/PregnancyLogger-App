package com.example.janitripregnancyassignment.vm
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.janitripregnancyassignment.data.VitalsEntity
import com.example.janitripregnancyassignment.db.VitalsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VitalsViewModel(private val repository: VitalsRepository) : ViewModel() {

    private val _vitalsList = MutableStateFlow<List<VitalsEntity>>(emptyList())
    val vitalsList = _vitalsList.asStateFlow()

    init {
        viewModelScope.launch {
            repository.allVitals.collect { vitals ->
                _vitalsList.value = vitals
            }
        }
    }

    fun addVitals(systolic: Int,
                  diastolic: Int,
                  heartRate: Int,
                  weight: Float,
                  babyKicks: Int,
                  createdAt: Long = System.currentTimeMillis()) {
        viewModelScope.launch {
            repository.insertVitals(
                VitalsEntity(systolic = systolic, diastolic = diastolic, heartRate = heartRate, weight = weight, babyKicks = babyKicks)
            )
        }
    }

    fun deleteVitals(vitals: VitalsEntity) {
        viewModelScope.launch {
            repository.deleteVitals(vitals)
        }
    }

}
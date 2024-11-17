package com.example.agrieyes.ui.screens.DiseaseRecord


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiseaseRecordViewModel @Inject constructor(

) : ViewModel() {
    private val _diseaseRecordUiState = MutableStateFlow(DiseaseRecordUiStates())
    val diseaseRecordUiState: StateFlow<DiseaseRecordUiStates> = _diseaseRecordUiState

    private val _isLoading = MutableStateFlow(false)

    fun refresh() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                _isLoading.value = false
            } catch (e: Exception) {
                // Xử lý ngoại lệ, ví dụ: log hoặc hiển thị thông báo lỗi
                Log.e("HomeViewModel", "Error occurred: ${e.message}")
            }
        }
    }

}
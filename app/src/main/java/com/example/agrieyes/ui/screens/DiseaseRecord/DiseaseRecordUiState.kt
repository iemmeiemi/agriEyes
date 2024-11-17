package com.example.agrieyes.ui.screens.DiseaseRecord

import com.example.agrieyes.data.Desease.Desease
import com.example.agrieyes.data.DiseaseRecord.DiseaseRecord

data class DiseaseRecordUiStates(
    val deseases: List<Desease> = emptyList(),
    val diseaseRecord: DiseaseRecord? = null,

    val isLoading: Boolean = false

)

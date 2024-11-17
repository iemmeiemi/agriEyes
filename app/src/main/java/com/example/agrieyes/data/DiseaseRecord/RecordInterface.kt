package com.example.agrieyes.data.DiseaseRecord

interface RecordInterface {
    suspend fun getRecords(): List<DiseaseRecord>
}
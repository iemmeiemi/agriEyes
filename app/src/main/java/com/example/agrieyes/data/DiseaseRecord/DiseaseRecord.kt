package com.example.agrieyes.data.DiseaseRecord

import java.util.Date


data class DiseaseRecord(
    val id:String,
    val desease: List<String>,
    val note: String,
    val imgs: List<String>,
    val marked: Boolean,
    val createdDate: Date,


) {
    constructor() : this("", emptyList(), "", emptyList(), false, Date())
}

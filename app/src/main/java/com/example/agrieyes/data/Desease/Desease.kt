package com.example.agrieyes.data.Desease

import java.util.Date

data class Desease(
    val id: String,
    val name: String,
    val des: String,
    val imgs: List<String>,
    val solutions: List<String>,
    val modifiedDate: Date,
) {
    constructor() : this("", "", "", emptyList(), emptyList(), Date())
}

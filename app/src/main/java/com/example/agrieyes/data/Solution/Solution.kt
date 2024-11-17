package com.example.agrieyes.data.Solution

import java.util.Date

data class Solution(
    val id: String,
    val name: String,
    val content: String,
    val author: String,
    val modifiedDate: Date,
) {
    constructor() : this("", "", "", "", Date())
}

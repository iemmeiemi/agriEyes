package com.example.agrieyes.data.News

import com.example.agrieyes.R

data class News(
    val id: String,
    val title: String,
    val content: String,
    val author: String,
    val img: Int = R.drawable.bando,
    val date: String,
)

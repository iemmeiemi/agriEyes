package com.example.agrieyes.ui.screens.home

import com.example.agrieyes.data.Desease.Desease
import com.example.agrieyes.data.Drone.Drone
import com.example.agrieyes.data.News.News

data class HomeUiStates(
    val deseases: List<Desease> = emptyList(),
    val news: List<News> = emptyList(),
    val drone: Drone = Drone("", "", "", "" ),

    val isLoading: Boolean = false

)

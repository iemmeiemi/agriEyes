package com.example.agrieyes.data.Desease

import com.example.agrieyes.data.Solution.Solution

interface DeseaseInterface {
    suspend fun getDeseases(): List<Desease>

    suspend fun refresh()
}
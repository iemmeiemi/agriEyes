package com.example.agrieyes.data.Solution

interface SolutionInterface {
    suspend fun getSolutions(): List<Solution>
}
package com.example.agrieyes.data.Solution

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SolutionRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val scope: CoroutineScope,
) : SolutionInterface {
    override suspend fun getSolutions(): List<Solution> {
        TODO("Not yet implemented")
    }

}

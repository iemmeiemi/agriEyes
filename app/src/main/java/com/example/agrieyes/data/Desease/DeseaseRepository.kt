package com.example.agrieyes.data.Desease

import com.example.agrieyes.data.Solution.Solution
import com.example.agrieyes.data.Solution.SolutionInterface
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeseaseRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val scope: CoroutineScope,
) : DeseaseInterface {
    override suspend fun getDeseases(): List<Desease> {
        TODO("Not yet implemented")
    }

    override suspend fun refresh() {
        withContext(dispatcher) {

        }
    }

}

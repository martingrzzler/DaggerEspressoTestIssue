package com.martingrzzler.testdaggerapp.repository

import com.martingrzzler.testdaggerapp.network.FakeApiService
import com.martingrzzler.testdaggerapp.network.User
import javax.inject.Inject

class FakeMainRepository @Inject constructor(
    private val apiService: FakeApiService
) : MainRepository {
    override suspend fun getUser(): User {
        val result = apiService.getUser()
        return  result[0]
    }

}
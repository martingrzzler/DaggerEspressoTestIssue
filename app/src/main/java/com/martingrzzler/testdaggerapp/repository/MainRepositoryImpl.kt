package com.martingrzzler.testdaggerapp.repository

import com.martingrzzler.testdaggerapp.network.ApiService
import com.martingrzzler.testdaggerapp.network.User
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MainRepository {


    override suspend fun getUser(): User {
        val result =  apiService.getUser()
        return result[0]
    }

}
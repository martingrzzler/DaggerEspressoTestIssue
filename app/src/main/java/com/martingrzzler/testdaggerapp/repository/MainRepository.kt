package com.martingrzzler.testdaggerapp.repository

import com.martingrzzler.testdaggerapp.network.User

interface MainRepository {

    suspend fun getUser(): User

}
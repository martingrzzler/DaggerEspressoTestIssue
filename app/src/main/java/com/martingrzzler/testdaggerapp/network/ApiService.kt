package com.martingrzzler.testdaggerapp.network

import com.martingrzzler.testdaggerapp.di.ActivityScope
import retrofit2.http.GET

interface ApiService {

    @GET("users?id=1")
    suspend fun getUser(): List<User>


    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

}
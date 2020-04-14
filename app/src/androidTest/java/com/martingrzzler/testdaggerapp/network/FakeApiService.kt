package com.martingrzzler.testdaggerapp.network

class FakeApiService: ApiService {
    override suspend fun getUser(): List<User> {
        return listOf(User(
            name = "Martin",
            username = "martingrzzler",
            email = "martin.gressler@code.berlin"
        ))
    }

}
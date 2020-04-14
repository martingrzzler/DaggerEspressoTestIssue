package com.martingrzzler.testdaggerapp.network

class FakeApiService: ApiService {
    override suspend fun getUser(): List<User> {
        return listOf(User(
            name = "Max",
            username = "maximus",
            email = "maximus@maximal.com"
        ))
    }

}
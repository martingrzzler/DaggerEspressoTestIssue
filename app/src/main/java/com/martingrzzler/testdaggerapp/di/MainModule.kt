package com.martingrzzler.testdaggerapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.martingrzzler.testdaggerapp.network.ApiService
import com.martingrzzler.testdaggerapp.repository.MainRepository
import com.martingrzzler.testdaggerapp.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object MainModule {


    @JvmStatic
    @ActivityScope
    @Provides
    fun provideApiService(retrofitBuilder: Retrofit.Builder): ApiService {
        return retrofitBuilder
            .build()
            .create(ApiService::class.java)
    }


    @JvmStatic
    @ActivityScope
    @Provides
    fun provideMainRepository(apiService: ApiService): MainRepository {
        return MainRepositoryImpl(apiService)
    }

    @JvmStatic
    @ActivityScope
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @JvmStatic
    @ActivityScope
    @Provides
    fun provideRetrofitBuilder(gsonBuilder: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    }

}
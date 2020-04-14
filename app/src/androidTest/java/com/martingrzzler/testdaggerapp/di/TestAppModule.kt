package com.martingrzzler.testdaggerapp.di

import androidx.lifecycle.ViewModelProvider
import com.martingrzzler.testdaggerapp.network.ApiService
import com.martingrzzler.testdaggerapp.network.FakeApiService
import com.martingrzzler.testdaggerapp.repository.FakeMainRepository
import com.martingrzzler.testdaggerapp.repository.MainRepository
import com.martingrzzler.testdaggerapp.viewmodels.FakeMainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TestAppModule  {


    @JvmStatic
    @ActivityScope
    @Provides
    fun provideFakeApiService(): FakeApiService {
        return FakeApiService()
    }

    @JvmStatic
    @ActivityScope
    @Provides
    fun provideFakeMainViewModelFactory(repository: FakeMainRepository): ViewModelProvider.Factory {
        return FakeMainViewModelFactory(repository)
    }

    @JvmStatic
    @ActivityScope
    @Provides
    fun provideFakeMainRepository(apiService: FakeApiService): MainRepository {
        return FakeMainRepository(apiService)
    }

}
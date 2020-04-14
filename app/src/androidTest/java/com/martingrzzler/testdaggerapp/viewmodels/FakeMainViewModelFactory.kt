package com.martingrzzler.testdaggerapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.martingrzzler.testdaggerapp.MainViewModel
import com.martingrzzler.testdaggerapp.repository.FakeMainRepository
import javax.inject.Inject

class FakeMainViewModelFactory @Inject constructor(private val repository: FakeMainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
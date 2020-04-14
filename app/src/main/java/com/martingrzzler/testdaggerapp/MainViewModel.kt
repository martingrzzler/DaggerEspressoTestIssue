package com.martingrzzler.testdaggerapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martingrzzler.testdaggerapp.network.User
import com.martingrzzler.testdaggerapp.repository.MainRepository
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    fun getUser() {
        viewModelScope.launch {
            try {
                val result = repository.getUser()
                _user.value = result
            } catch (ex: IOException) {
                Log.i("AppDebug", "MainViewModel: NETWORK ERROR")
            }
        }

    }



}
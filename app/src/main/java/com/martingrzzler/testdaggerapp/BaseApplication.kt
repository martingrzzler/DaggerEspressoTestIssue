package com.martingrzzler.testdaggerapp

import android.app.Application
import com.martingrzzler.testdaggerapp.di.AppComponent
import com.martingrzzler.testdaggerapp.di.DaggerAppComponent

open class BaseApplication : Application() {

    open lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    open fun initAppComponent() {
        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }

}
package com.martingrzzler.testdaggerapp

import com.martingrzzler.testdaggerapp.di.DaggerTestAppComponent

class TestBaseApplication : BaseApplication() {

    override fun initAppComponent() {
        appComponent = DaggerTestAppComponent
            .builder()
            .application(this)
            .build()
    }
}
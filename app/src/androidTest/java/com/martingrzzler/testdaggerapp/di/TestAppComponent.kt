package com.martingrzzler.testdaggerapp.di

import android.app.Application
import com.martingrzzler.testdaggerapp.MainActivityTest
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        TestAppModule::class
    ]
)
interface TestAppComponent: AppComponent{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): TestAppComponent
    }


    fun inject(mainActivityTest: MainActivityTest)

}
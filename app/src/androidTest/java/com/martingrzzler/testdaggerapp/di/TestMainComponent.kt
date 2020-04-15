package com.martingrzzler.testdaggerapp.di

import com.martingrzzler.testdaggerapp.MainActivityTest
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [TestAppModule::class])
interface TestMainComponent: MainComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): TestMainComponent
    }

    fun inject(mainActivityTest: MainActivityTest)
}
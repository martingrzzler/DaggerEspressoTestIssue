package com.martingrzzler.testdaggerapp.di

import com.martingrzzler.testdaggerapp.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MainModule::class, ViewModelModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)

}
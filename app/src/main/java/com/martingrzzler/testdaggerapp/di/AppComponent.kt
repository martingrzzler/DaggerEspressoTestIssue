package com.martingrzzler.testdaggerapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SubComponentsModule::class,
        AppModule::class
    ]
)
interface AppComponent{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun mainComponent(): MainComponent.Factory

}
package com.example.dagger2.di

import android.content.Context
import com.example.dagger2.BaseApplication
import dagger.Module
import dagger.Provides

@Module
abstract class AppModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun getString(): String { return "Say something!"}

        @JvmStatic
        @Provides
        fun getAppContext(application: BaseApplication): Context {
            return application.applicationContext
        }
    }
}
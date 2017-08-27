package com.davidshalom.footballfollower

import android.app.Application
import com.davidshalom.footballfollower.di.components.AppComponent
import com.davidshalom.footballfollower.di.components.DaggerAppComponent
import com.davidshalom.footballfollower.di.modules.AppModule

class App : Application() {

    companion object {
        @JvmStatic lateinit var instance: App
    }
    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
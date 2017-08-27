package com.davidshalom.footballfollower

import android.app.Application
import com.davidshalom.footballfollower.di.components.AppComponent
import com.davidshalom.footballfollower.di.components.DaggerAppComponent
import com.davidshalom.footballfollower.di.modules.AppModule

class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}
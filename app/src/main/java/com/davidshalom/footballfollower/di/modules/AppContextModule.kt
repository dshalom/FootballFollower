package com.davidshalom.footballfollower.di.modules

import android.content.Context
import android.content.res.Resources
import com.davidshalom.footballfollower.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppContextModule {

    @Provides
    @Singleton
    fun provideContext(): Context = App.instance

    @Provides
    @Singleton
    fun provideResources(context: Context): Resources = context.getResources()

}
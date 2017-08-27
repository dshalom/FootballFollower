package com.davidshalom.footballfollower.di.modules

import com.davidshalom.footballfollower.App
import com.davidshalom.footballfollower.Toolbox
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule() {
    
    @Provides
    @Singleton
    fun provideToolbox(): Toolbox {
        return Toolbox();
    }

}
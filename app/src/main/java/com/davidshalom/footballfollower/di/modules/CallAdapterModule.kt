package com.davidshalom.footballfollower.di.modules

import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton

@Module
class CallAdapterModule {

    @Provides
    @Singleton
    fun provideAdapter(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()
}
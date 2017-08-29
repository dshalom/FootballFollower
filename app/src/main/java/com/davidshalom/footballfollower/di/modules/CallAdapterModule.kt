package com.davidshalom.footballfollower.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class CallAdapterModule {

    @Provides
    @Singleton
    fun provideAdapter(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()
}
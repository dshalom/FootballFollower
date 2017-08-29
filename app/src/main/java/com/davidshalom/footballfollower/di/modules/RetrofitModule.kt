package com.davidshalom.footballfollower.di.modules

import com.davidshalom.footballfollower.model.services.FootballService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient, baseUrl: String, converter: Converter.Factory, callAdapter: CallAdapter.Factory ): Retrofit {

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(callAdapter)
                .addConverterFactory(converter)
                .client(httpClient).build()

    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): FootballService {
        return retrofit.create(FootballService::class.java)
    }

}
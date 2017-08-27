package xyz.ivankocijan.kotlinexample.dagger.setup.module

import com.davidshalom.footballfollower.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
@Module
class HostModule {

    val NETWORK_TIMEOUT_SECONDS = 60L

    @Provides
    @Singleton
    fun provideNetworkTimeout(): Long = NETWORK_TIMEOUT_SECONDS

    @Provides
    @Singleton
    fun provideBaseUrl(): String = BuildConfig.API_URL

}
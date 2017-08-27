package xyz.ivankocijan.kotlinexample.dagger.setup.module

import android.content.Context
import android.content.res.Resources
import com.davidshalom.footballfollower.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 20/03/16
 */
@Module
class AppContextModule {

    @Provides
    @Singleton
    fun provideContext(): Context = App.instance

    @Provides
    @Singleton
    fun provideResources(context: Context): Resources = context.getResources()

}
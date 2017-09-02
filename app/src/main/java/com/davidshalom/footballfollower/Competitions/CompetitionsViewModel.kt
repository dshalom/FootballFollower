package com.davidshalom.footballfollower.Competitions

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.davidshalom.footballfollower.Spanner
import com.davidshalom.footballfollower.di.components.AppComponent
import com.davidshalom.footballfollower.di.components.RepositoryComponent
import javax.inject.Inject


class CompetitionsViewModel : ViewModel(), AppComponent.Injectable  {

    @Inject lateinit var competitionsRepository: CompetitionsRepository

    override fun inject(countdownComponent: AppComponent) {
        countdownComponent.inject(this)
    }

    fun doit() {
        Log.e("dsds", "doit");

        competitionsRepository.doit()
    }
}

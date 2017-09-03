package com.davidshalom.footballfollower.Competitions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.davidshalom.footballfollower.di.components.AppComponent
import javax.inject.Inject


class CompetitionsViewModel : ViewModel(), AppComponent.Injectable {

    lateinit var user: LiveData<ApiResponse>
    @Inject lateinit var competitionsRepository: CompetitionsRepository

    override fun inject(countdownComponent: AppComponent) {
        countdownComponent.inject(this)
    }

    fun init() {
//        if (this.user != null) {
//            // ViewModel is created per Fragment so
//            // we know the userId won't change
//            return
//        }
        user = competitionsRepository.getCompetitions()
    }

    fun getCompetitions(): LiveData<ApiResponse> {
        return user
    }


}

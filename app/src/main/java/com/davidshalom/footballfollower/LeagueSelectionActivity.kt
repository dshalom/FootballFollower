package com.davidshalom.footballfollower

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.davidshalom.footballfollower.di.modules.LeagueSelectionModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.davidshalom.footballfollower.model.services.FootballService
import javax.inject.Inject

class LeagueSelectionActivity : AppCompatActivity() {
    @Inject lateinit var footballService: FootballService
    @Inject lateinit var spanner: Spanner

    val component by lazy { app.component.plus(LeagueSelectionModule(this)) }

    val Activity.app: App
        get() = application as App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_selection)
        component.inject(this)

        footballService.getCompetitions()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { competitions -> Log.e("dsds", competitions.get(0).caption) },
                        { error -> Log.e("dsds", error.message) }
                )

        spanner.doit()
    }
}

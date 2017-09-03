package com.davidshalom.footballfollower.Competitions

import android.app.Activity
import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import com.davidshalom.footballfollower.App
import com.davidshalom.footballfollower.R
import com.davidshalom.footballfollower.Spanner
import com.davidshalom.footballfollower.di.RepositoryFactory
import com.davidshalom.footballfollower.di.modules.LeagueSelectionModule
import javax.inject.Inject

class LeagueSelectionActivity : LifecycleActivity() {
    @Inject lateinit var spanner: Spanner
    lateinit var viewModel: CompetitionsViewModel

    val component by lazy { app.component.plus(LeagueSelectionModule(this)) }

    val Activity.app: App
        get() = application as App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_selection)
        component.inject(this)
        spanner.doit()

        viewModel = ViewModelProviders.of(this, RepositoryFactory(app))
                .get(CompetitionsViewModel::class.java)

        viewModel.init()
        viewModel.getCompetitions().observe(this, Observer({ apiResponse ->
            Log.e("dsds", apiResponse?.get(0)?.caption)
        }))

    }
}

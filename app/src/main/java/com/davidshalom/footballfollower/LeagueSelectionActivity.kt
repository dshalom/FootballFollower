package com.davidshalom.footballfollower

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

class LeagueSelectionActivity : AppCompatActivity() {

    @Inject lateinit var toolbox: Toolbox

    val Activity.app: App
        get() = application as App

    override fun onCreate(savedInstanceState: Bundle?) {

        app.component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_selection)
        toolbox.doit()

    }
}

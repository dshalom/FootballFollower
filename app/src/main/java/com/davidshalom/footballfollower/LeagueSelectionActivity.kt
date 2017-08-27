package com.davidshalom.footballfollower

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.davidshalom.footballfollower.di.modules.LeagueSelectionModule
import xyz.ivankocijan.kotlinexample.PokemonService
import javax.inject.Inject

class LeagueSelectionActivity : AppCompatActivity() {

    @Inject lateinit var pokemonService: PokemonService

    val component by lazy { app.component.plus(LeagueSelectionModule(this)) }

    val Activity.app: App
        get() = application as App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_selection)
        component.inject(this)

        if (pokemonService == null) {
            Log.e("dsds", "its null")
        } else {
            Log.e("dsds", "its not null")

        }
    }
}

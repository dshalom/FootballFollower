package com.davidshalom.footballfollower.db.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Competition(@PrimaryKey var id: Int, @SerializedName("caption") val caption: String)

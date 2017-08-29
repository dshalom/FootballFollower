package com.davidshalom.footballfollower.model.entities

import com.google.gson.annotations.SerializedName

data class Competition(
        @SerializedName("caption") val caption: String
)

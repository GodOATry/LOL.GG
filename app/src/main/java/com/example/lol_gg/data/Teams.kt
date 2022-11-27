package com.example.lol_gg.data

import com.google.gson.annotations.SerializedName



data class Teams (

    @SerializedName("teamId") val teamId : Int,
    @SerializedName("win") val win : Boolean
)
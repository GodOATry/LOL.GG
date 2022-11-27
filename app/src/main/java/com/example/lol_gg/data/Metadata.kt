package com.example.lol_gg.data

import com.google.gson.annotations.SerializedName

data class Metadata (

	@SerializedName("dataVersion") val dataVersion : Int = 0,
	@SerializedName("matchId") val matchId : String = "",
	@SerializedName("participants") val participants : List<String> = listOf()
)
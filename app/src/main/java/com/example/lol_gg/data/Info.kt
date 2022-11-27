package com.example.lol_gg.data

import com.google.gson.annotations.SerializedName


data class Info (

	@SerializedName("gameCreation") val gameCreation : Long = 0,
	@SerializedName("gameDuration") val gameDuration : Long = 0,
	@SerializedName("gameEndTimestamp") val gameEndTimestamp : Long = 0,
	@SerializedName("gameId") val gameId : Long = 0,
	@SerializedName("gameMode") val gameMode : String = "",
	@SerializedName("gameName") val gameName : String = "",
	@SerializedName("gameStartTimestamp") val gameStartTimestamp : Long = 0,
	@SerializedName("gameType") val gameType : String = "",
	@SerializedName("gameVersion") val gameVersion : String = "",
	@SerializedName("mapId") val mapId : Long = 0,
	@SerializedName("participants") val participants : List<Participants> = listOf(),
	@SerializedName("platformId") val platformId : String = "",
	@SerializedName("queueId") val queueId : Long = 0,
	@SerializedName("teams") val teams : List<Teams> = listOf(),
	@SerializedName("tournamentCode") val tournamentCode : String = ""
)
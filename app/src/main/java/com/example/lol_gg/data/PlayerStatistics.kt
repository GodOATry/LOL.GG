package com.example.lol_gg.data

data class PlayerStatistics(
    val leagueId: String = "",
    val queueTpe: String = "",
    val tier: String = "",
    val rank: String = "",
    val summonerId: String = "",
    val summonerName: String = "",
    val leaguePoints: Int = 0,
    val wins: Int = 0,
    val losses: Int = 0,
    val isVeteran: Boolean = false,
    val isInactive: Boolean = false,
    val isFreshBlood: Boolean = false,
    val isHotStreak: Boolean = false
)

package com.example.lol_gg.data

data class EsportMatch(
    val region: String,
    val time: String,
    val date: String,
    val team1: String,
    val team2: String,
    val score1: Int,
    val score2:Int,
    val teamScore1: String,
    val teamScore2: String
)

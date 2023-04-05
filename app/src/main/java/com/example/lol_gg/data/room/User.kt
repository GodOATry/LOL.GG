package com.example.lol_gg.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "summoner_name")
    val summonerName: String = "",
    @ColumnInfo(name = "summoner_server")
    val summonerServer: String = "",
    @ColumnInfo(name = "summoner_rank")
    val summonerRank: String = "",
    @ColumnInfo(name = "summoner_tier")
    val summonerTier: String = "",
    @ColumnInfo(name = "summoner_league_id")
    val summonerLeagueId: String = ""

)

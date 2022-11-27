package com.example.lol_gg.api

import com.example.lol_gg.data.Match
import retrofit2.http.GET

interface RiotApi {

    @GET("EUN1_3231398968?api_key=RGAPI-20089434-3915-4d97-801e-acec20823d4f")
    suspend fun getGameInfo(): Match

}

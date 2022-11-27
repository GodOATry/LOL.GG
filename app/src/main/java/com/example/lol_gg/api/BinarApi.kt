package com.example.lol_gg.api

import com.example.lol_gg.data.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BinarApi {
    @GET("stats/Statistics")
    suspend fun getPlayerStatistics(@Query("summonerName") summonerName:String, @Query("region") summonerRegion:String): PlayerStatistics
    @GET("stats/game_history")
    suspend fun getPlayerMatchHistory(@Query("summonerName") summonerName:String, @Query("region") summonerRegion:String): List<Match>
    @POST("users/create_user")
    suspend fun registerUser(@Body registrationJson: RegistrationJson): ReturnDataFromRegistration
    @POST("users/sign_in")
    suspend fun signInUser(@Body signingIn: SigningInJson): ReturnDataFromSigningIn

}
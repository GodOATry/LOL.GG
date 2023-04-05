package com.example.lol_gg.api.repositories

import com.example.lol_gg.api.BinarApi
import com.example.lol_gg.api.NetworkResult
import com.example.lol_gg.data.Match
import com.example.lol_gg.data.PlayerStatistics
import javax.inject.Inject

interface HomeScreenRepository {
    suspend fun getPlayerStatistics(summonerName: String, summonerRegion: String): NetworkResult<PlayerStatistics>
    suspend fun getPlayerMatchHistory(summonerName: String, summonerRegion: String): NetworkResult<List<Match>>
    suspend fun saveSummonerName(summonerName: String): NetworkResult<String>
}

class HomeScreenRepositoryImplementation @Inject constructor(
    private val binarApi: BinarApi
) : HomeScreenRepository {

    override suspend fun getPlayerStatistics(
        summonerName: String,
        summonerRegion: String
    ): NetworkResult<PlayerStatistics> {
        return try {
            val result = binarApi.getPlayerStatistics(summonerName, summonerRegion)
            NetworkResult.Success(result)
        } catch (e: Exception) {
            NetworkResult.Failure(e.message, e, 0)
        }
    }

    override suspend fun getPlayerMatchHistory(
        summonerName: String,
        summonerRegion: String
    ): NetworkResult<List<Match>> {
        return try {
            val result = binarApi.getPlayerMatchHistory(summonerName, summonerRegion)
            NetworkResult.Success(result)
        } catch (e: Exception) {
            NetworkResult.Failure(e.message, e, 0)
        }
    }

    override suspend fun saveSummonerName(summonerName: String): NetworkResult<String> {
        // TODO add call when backend is ready. Beneath is just simple mock to allow project to build itself.
        return NetworkResult.Success("")
    }
}

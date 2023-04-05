package com.example.lol_gg.screen.home

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beust.klaxon.Klaxon
import com.example.example.Champ
import com.example.example.Data
import com.example.example.DataItem
import com.example.lol_gg.data.items.Item
import com.example.example.TMP
import com.example.lol_gg.R
import com.example.lol_gg.api.NetworkResult
import com.example.lol_gg.api.repositories.HomeScreenRepository
import com.example.lol_gg.api.repositories.RoomRepository
import com.example.lol_gg.data.*
import com.example.lol_gg.data.items.SpecificItemData
import com.example.lol_gg.data.room.User
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import java.io.IOException
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeScreenController: HomeScreenRepository,
    private val roomRepository: RoomRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val listOfRegionsForApi =
        listOf("BR1", "EUN1", "EUW1", "JP1", "KR", "LA1", "LA2", "NA1", "OC1", "RU", "TR1")
    private val listOfRegions =
        listOf("BR", "EUNE", "EUW", "JP", "KR", "LAN", "LAS", "NA", "OC", "RU", "TR")
    val listOfRegionsFullNames = listOf(
        "Brazil",
        "Europe Nordic & East",
        "Europe West",
        "Japan",
        "Korea",
        "LAN",
        "LAS",
        "North America",
        "Oceania",
        "Russia",
        "Turkey"
    )

    private var _chosenRegion = mutableStateOf(listOfRegions[1])
    val chosenRegion = _chosenRegion

    var isProgressBarVisible = mutableStateOf(false)

    var userStatistics = mutableStateOf(PlayerStatistics())
    var userParticipant = mutableStateOf(mutableListOf(Participants()))
    var gameInfo = mutableStateOf(mutableListOf(Info()))
    val homeEvent = MutableSharedFlow<HomeEvents>()

    fun chooseRegion(listItemPosition: Int) {
        _chosenRegion.value = listOfRegions[listItemPosition]
    }

    private fun downloadOneMatchHistory(summonerName: String) {
        viewModelScope.launch {
            when (
                val result = homeScreenController.getPlayerMatchHistory(
                    summonerName,
                    listOfRegionsForApi[listOfRegions.indexOf(_chosenRegion.value)]
                )
            ) {
                is NetworkResult.Success -> {
                    gameInfo.value.clear()
                    userParticipant.value.clear()
                    val tmpGameInfo = mutableListOf<Info>()
                    val tmpUserParticipants = mutableListOf<Participants>()
                    for (match: Match in result.value) {
                        tmpGameInfo.add(match.info)
                        for (participant: Participants in match.info.participants) {
                            if (participant.summonerName == summonerName.replaceFirstChar { it.uppercase() }) {
                                tmpUserParticipants.add(participant)
                            }
                        }
                    }
                    gameInfo.value = tmpGameInfo
                    userParticipant.value = tmpUserParticipants
                    changeProgressBarState()
                }
                is NetworkResult.Failure -> {
                    changeProgressBarState()
                    homeEvent.emit(HomeEvents.HttpException())
                }
            }
        }
    }




    fun downloadStatistics(summonerName: String, region: String = "") {

        changeProgressBarState()
        viewModelScope.launch {
            when (
                val result = homeScreenController.getPlayerStatistics(
                    summonerName,
                    if (region.isEmpty()) {
                        listOfRegionsForApi[listOfRegions.indexOf(_chosenRegion.value)]
                    } else {
                        listOfRegionsForApi[listOfRegions.indexOf(region)]
                    }

                )
            ) {
                is NetworkResult.Success -> {
                    userStatistics.value = result.value
                    downloadOneMatchHistory(summonerName)
                }
                is NetworkResult.Failure -> {
                    changeProgressBarState()
                    homeEvent.emit(HomeEvents.HttpException())
                }
            }
        }
    }

    fun calculateKDA(kills: Int, deaths: Int, assists: Int): String {
        return if (deaths != 0) {
            BigDecimal(((kills + assists).toDouble() / deaths.toDouble())).setScale(
                2,
                RoundingMode.HALF_EVEN
            ).toString()
        } else {
            BigDecimal(((kills + assists).toDouble())).setScale(
                2,
                RoundingMode.HALF_EVEN
            ).toString()
        }
    }

    fun saveSummonerName(summonerName: String) {
        viewModelScope.launch {
            val summonerNames = roomRepository.getAllSummonerNames()
            if (summonerName.isNotEmpty() && !summonerNames.map { it.summonerName }
                    .contains(summonerName)
            ) {
                changeProgressBarState()
                when (
                    val result = homeScreenController.getPlayerStatistics(
                        summonerName,
                        listOfRegionsForApi[listOfRegions.indexOf(_chosenRegion.value)]
                    )
                ) {
                    is NetworkResult.Success -> {
                        roomRepository.saveSummonerName(
                            User(
                                summonerName = result.value.summonerName,
                                summonerServer = _chosenRegion.value,
                                summonerLeagueId = result.value.summonerId,
                                summonerRank = result.value.rank,
                                summonerTier = result.value.tier
                            )
                        )
                        changeProgressBarState()
                    }
                    is NetworkResult.Failure -> {
                        changeProgressBarState()
                        homeEvent.emit(HomeEvents.HttpException())
                    }
                }
            }
        }
    }

    private fun changeProgressBarState() {
        isProgressBarVisible.value = !isProgressBarVisible.value
    }

    fun calculateWinRate(wins: Int, loses: Int): Int {
        return ((wins.toFloat() / (wins + loses).toFloat()) * 100).toInt()
    }

    fun calculateGameDuration(gameDuration: Long): String {
        return if (gameDuration % 60 > 10) {
            (gameDuration / 60).toString() + ":" + (gameDuration % 60).toString()
        } else {
            (gameDuration / 60).toString() + ":0" + (gameDuration % 60).toString()
        }
    }

 val listOfChamps = listOf<String>("a"
 )



}

sealed class HomeEvents {
    data class HttpException(val messageId: Int = R.string.HttpException) : HomeEvents()
    data class SaveSummonerNameSuccessful(val messageId: Int = R.string.successful_saving_summoner_name) : HomeEvents()
    data class SaveSummonerNameUnSuccessful(val messageId: Int = R.string.unsuccessful_saving_summoner_name) : HomeEvents()
}

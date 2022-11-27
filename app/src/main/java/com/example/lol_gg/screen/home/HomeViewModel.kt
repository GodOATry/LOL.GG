package com.example.lol_gg.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lol_gg.api.NetworkResult
import com.example.lol_gg.api.repositories.HomeScreenRepository
import com.example.lol_gg.data.*
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.lol_gg.R


import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeScreenController: HomeScreenRepository
) : ViewModel() {
    val listOfRegionsForApi =
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
            when (val result = homeScreenController.getPlayerMatchHistory(
                summonerName,
                listOfRegionsForApi[listOfRegions.indexOf(_chosenRegion.value)]
            )) {
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

    fun downloadStatistics(summonerName: String) {
        changeProgressBarState()
        viewModelScope.launch {
            when (val result = homeScreenController.getPlayerStatistics(
                summonerName,
                listOfRegionsForApi[listOfRegions.indexOf(_chosenRegion.value)]
            )) {
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


    private fun changeProgressBarState() {
        isProgressBarVisible.value = !isProgressBarVisible.value
    }

    fun calculateWinRate(wins: Int, loses: Int): Int {
        return ((wins.toFloat() / (wins + loses).toFloat()) * 100).toInt()
    }
    fun calculateGameDuration(gameDuration: Long): String{
        return if (gameDuration % 60 > 10) {
            (gameDuration / 60).toString() + ":" + (gameDuration % 60).toString()
        }else{
            (gameDuration / 60).toString() + ":0" + (gameDuration % 60).toString()
        }
    }
}

sealed class HomeEvents {
    data class HttpException(val messageId: Int = R.string.HttpException) : HomeEvents()
}




package com.example.lol_gg.screen.esport

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.lol_gg.R
import com.example.lol_gg.data.EsportMatch
import com.example.lol_gg.data.RegionData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EsportViewModel @Inject constructor() : ViewModel() {
    val region = mutableStateOf(RegionData(icon = R.drawable.trophy, name="WORLD", id = 0))
    val region1 = mutableStateOf(RegionData(icon = R.drawable.trophy, name="LCK", id = 1))
    val region2 = mutableStateOf(RegionData(icon = R.drawable.trophy, name="LCS", id = 2))
    val region3 = mutableStateOf(RegionData(icon = R.drawable.trophy, name="LEC", id = 3))
    var chosenRegion = mutableStateOf<RegionData>(RegionData(id = 0, icon = 1))
    val listOfMatches = mutableStateOf(mutableListOf(
        EsportMatch(region = "LEC", time = "8:00", date = "19.11.2022", team1 = "AST", team2 = "BDS", score1 = 1, score2 = 0, teamScore1 = "2W-0L", teamScore2 = "1W-1L"),
        EsportMatch(region = "LEC", time = "18:00", date = "29.11.2022", team1 = "G2", team2 = "FNC", score1 = 0, score2 = 1, teamScore1 = "2W-0L", teamScore2 = "1W-1L"),
        EsportMatch(region = "LCK", time = "10:00", date = "07.09.2022", team1 = "T1", team2 = "GG", score1 = 1, score2 = 0, teamScore1 = "2W-0L", teamScore2 = "1W-1L"),
        EsportMatch(region = "LCS", time = "13:30", date = "21.10.2022", team1 = "C9", team2 = "100", score1 = 1, score2 = 0, teamScore1 = "2W-0L", teamScore2 = "1W-1L"),
    ))


    fun changeChosenRegion(index: Int) {
        when (index) {
            0 -> {
                chosenRegion.value = region.value
            }
            1 -> {
                chosenRegion.value = region1.value
            }
            2 -> {
                chosenRegion.value = region2.value
            }
            else -> {
                chosenRegion.value = region3.value
            }
        }
    }
}
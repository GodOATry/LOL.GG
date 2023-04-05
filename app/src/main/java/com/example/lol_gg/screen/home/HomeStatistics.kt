package com.example.lol_gg.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lol_gg.Dictionary
import com.example.lol_gg.ui.theme.WhiteAlpha06
import com.example.lol_gg.ui.theme.WhiteAlpha08

@Composable
fun HomeStatistics(homeViewModel: HomeViewModel) {
    val dictionary = Dictionary()
    val userStatistics = homeViewModel.userStatistics
    val userRank = userStatistics.value.rank
    val userPoints = userStatistics.value.leaguePoints
    val userTier = userStatistics.value.tier
    val userWins = userStatistics.value.wins
    val userLoses = userStatistics.value.losses
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Column(modifier = Modifier) {
            Row {
                if (dictionary.rankIconDictionary(userTier) != 0) {
                    Image(
                        painterResource(id = dictionary.rankIconDictionary(userTier)),
                        contentDescription = ""
                    )
                    Column(modifier = Modifier.padding(top = 50.dp)) {
                        val tmpRank = stringResource(id = dictionary.rankSmallLettersDictionary(userTier))
                        Text(text = "Ranked Solo/Duo", color = WhiteAlpha08)
                        Text(text = "$tmpRank $userRank", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 26.sp)
                        Text(text = "$userPoints LP", color = WhiteAlpha08)
                        Text(
                            text = "$userWins W $userLoses L (${
                                homeViewModel.calculateWinRate(
                                    userWins,
                                    userLoses
                                )
                            }%)",
                            color = WhiteAlpha06
                        )
                    }
                }
            }
            // TODO Graph LG-12
        }
    }
}

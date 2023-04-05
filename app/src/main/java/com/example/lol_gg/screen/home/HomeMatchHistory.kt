package com.example.lol_gg.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.lol_gg.Dictionary
import com.example.lol_gg.ui.theme.*

@Composable
fun HomeMatchHistory(homeViewModel: HomeViewModel, listPosition: Int) {
    val dictionary = Dictionary()
    val participant = homeViewModel.userParticipant.value[listPosition]
    val info = homeViewModel.gameInfo.value[listPosition]
    val champion = participant.championName
    val summonerSpell1 = participant.summoner1Id
    val summonerSpell2 = participant.summoner2Id
    val kills = participant.kills
    val deaths = participant.deaths
    val assists = participant.assists
    val gameMode = info.gameMode
    val isWon = participant.win
    val item0 = participant.item0
    val item1 = participant.item1
    val item2 = participant.item2
    val item3 = participant.item3
    val item4 = participant.item4
    val item5 = participant.item5
    val trinket = participant.item6
    val gameDuration = info.gameDuration

    if (champion.isNotEmpty()) {
        val rune1 = participant.perks.styles[0].style
        val rune2 = participant.perks.styles[1].style
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .background(SecondaryColor)
                .fillMaxWidth()
                .height(130.dp)
        ) {
            Column(modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)) {
                Row(modifier = Modifier.padding(start = 8.dp, bottom = 2.dp)) {
                    Image(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(WhiteAlpha01),
                        painter = rememberAsyncImagePainter(model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/champion/$champion.png"),
                        contentDescription = null
                    )
                    Column(modifier = Modifier.padding(start = 1.dp)) {
                        AsyncImage(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/spell/${
                                dictionary.summonerSpellIdDictionary(
                                    summonerSpell1
                                )
                            }",
                            contentDescription = null
                        )
                        AsyncImage(
                            modifier = Modifier
                                .padding(top = 2.dp)
                                .size(40.dp)
                                .clip(CircleShape),
                            model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/spell/${
                                dictionary.summonerSpellIdDictionary(
                                    summonerSpell2
                                )
                            }",
                            contentDescription = null
                        )
                    }
                    Column(modifier = Modifier.padding(start = 1.dp)) {
                        Image(
                            modifier = Modifier
                                .size(35.dp),
                            painter = painterResource(id = dictionary.perkDictionary(rune1)),
                            contentDescription = null
                        )
                        Image(
                            modifier = Modifier
                                .padding(top = 2.dp)
                                .size(35.dp),
                            painter = painterResource(id = dictionary.perkDictionary(rune2)),
                            contentDescription = null
                        )
                    }
                    Column(modifier = Modifier.padding(start = 5.dp)) {
                        Text(
                            text = "$kills/$deaths/$assists",
                            color = WhiteAlpha08,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                        Text(
                            text = "KDA : " + homeViewModel.calculateKDA(kills, deaths, assists),
                            color = WhiteAlpha04,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top = 12.dp)
                        )
                    }
                }
                Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    AsyncImage(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .size(40.dp)
                            .clip(CircleShape),
                        model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/$item0.png",
                        contentDescription = null
                    )
                    AsyncImage(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .size(40.dp)
                            .clip(CircleShape),
                        model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/$item1.png",
                        contentDescription = null
                    )
                    AsyncImage(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .size(40.dp)
                            .clip(CircleShape),
                        model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/$item2.png",
                        contentDescription = null
                    )
                    AsyncImage(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .size(40.dp)
                            .clip(CircleShape),
                        model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/$item3.png",
                        contentDescription = null
                    )
                    AsyncImage(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .size(40.dp)
                            .clip(CircleShape),
                        model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/$item4.png",
                        contentDescription = null
                    )
                    AsyncImage(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .size(40.dp)
                            .clip(CircleShape),
                        model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/$item5.png",
                        contentDescription = null
                    )
                    AsyncImage(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .size(40.dp)
                            .clip(CircleShape),
                        model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/$trinket.png",
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .padding(start = 1.dp)
                    .fillMaxHeight()
                    .width(50.dp)
                    .background(
                        if (isWon) {
                            win
                        } else {
                            lose
                        }
                    ),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = dictionary.typeOfGameDictionary(gameMode),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(4.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = dictionary.winDictionary(isWon),
                    color = Color.White,
                    modifier = Modifier.padding(4.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = homeViewModel.calculateGameDuration(gameDuration),
                    color = Color.White,
                    modifier = Modifier.padding(4.dp),
                    maxLines = 1
                )
            }
        }
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(5.dp)
            .background(Color.Transparent)
    )
}

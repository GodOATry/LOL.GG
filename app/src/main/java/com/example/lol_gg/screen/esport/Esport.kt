package com.example.lol_gg.screen.esport

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lol_gg.Dictionary
import com.example.lol_gg.data.RegionData
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.systemBarsPadding
import com.example.lol_gg.data.EsportMatch
import com.example.lol_gg.ui.theme.*

@Composable
fun Esport(esportViewModel: EsportViewModel) {
    EsportHistory(esportViewModel)


}

@Composable
fun EsportHistory(esportViewModel: EsportViewModel) {
    val listOfMatches = esportViewModel.listOfMatches.value
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            item {
                Text(
                    text = "Esports", //TODO String resources
                    color = WhiteAlpha08,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            item {
                EsportChoseRegion(esportViewModel)
            }
            itemsIndexed(
                items = listOfMatches,
                key = { _, item -> item.hashCode() }) { index, item ->
                EsportMatch(item,esportViewModel)
            }

        })


}

@Composable
fun EsportChoseRegion(esportViewModel: EsportViewModel) {
    val region = esportViewModel.region.value
    val region1 = esportViewModel.region1.value
    val region2 = esportViewModel.region2.value
    val region3 = esportViewModel.region3.value

    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 15.dp, end = 15.dp), content = {
        itemsIndexed(
            items = listOf(region,region1, region2, region3),
            key = { _, item -> item.hashCode() }) { index, item ->
            Region(regionData = item, esportViewModel = esportViewModel, index = index)
        }
    })
}

@Composable
fun Region(
    esportViewModel: EsportViewModel,
    regionData: RegionData,
    index: Int
) {
    val dictionary = Dictionary()
    val chosenRegionId = esportViewModel.chosenRegion.value

    Column(
        modifier = Modifier.padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = if (regionData.id == chosenRegionId.id) {
                Modifier.border(
                    BorderStroke(2.dp, WhiteAlpha08),
                    shape = RoundedCornerShape(16.dp)
                )
            } else {
                Modifier
            }
        ) {
            Card(modifier = Modifier
                .size(60.dp)
                .clickable { esportViewModel.changeChosenRegion(index) }
                .background(color = MainBackground2), backgroundColor = MainBackground2
            ) {
                Image(
                    painter = painterResource(id = dictionary.regionDictionary(regionData.name)),
                    contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)
                        .align(alignment = Alignment.Center)
                )

            }
        }

        Text(text = regionData.name, color = WhiteAlpha08)
    }
}

@Composable
fun EsportMatch(
    esportMatch: EsportMatch,
esportViewModel: EsportViewModel
) {
    val dictionary = Dictionary()
    val whoWon = esportMatch.score1 > esportMatch.score2
    val chosenRegionId = esportViewModel.chosenRegion.value
    if(esportMatch.region == chosenRegionId.name||chosenRegionId.id == 0){
        Text(text = esportMatch.date, color = WhiteAlpha08)
        Card(
            modifier = Modifier
                .fillMaxWidth().height(80.dp)
                .padding(10.dp), elevation = 5.dp
        ) {
            Row(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
                Box(
                    modifier = Modifier
                        .background(
                            color = if (whoWon) {
                                winAlpha06
                            } else {
                                loseAlpha06
                            }
                        )
                        .fillMaxWidth(0.5f).fillMaxHeight()
                ) {
                    Row(modifier = Modifier.align(Alignment.Center)) {
                        Text(
                            text = esportMatch.time,
                            color = WhiteAlpha08,
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = esportMatch.team1, color = if (whoWon) {
                                    WhiteAlpha08
                                } else {
                                    WhiteAlpha04
                                }
                            )
                            Text(
                                text = esportMatch.teamScore1, color = if (whoWon) {
                                    WhiteAlpha08
                                } else {
                                    WhiteAlpha04
                                }
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(id = dictionary.teamsDictionary(esportMatch.team1)), contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = esportMatch.score1.toString(),
                            color = if (whoWon) {
                                WhiteAlpha08
                            } else {
                                WhiteAlpha04
                            },
                            fontSize = 30.sp,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .background(
                            color = if (!whoWon) {
                                winAlpha06
                            } else {
                                loseAlpha06
                            }
                        )
                        .fillMaxWidth().fillMaxHeight()
                ) {
                    Row(modifier = Modifier.align(Alignment.Center)) {
                        Text(
                            text = esportMatch.score2.toString(),
                            color = if (!whoWon) {
                                WhiteAlpha08
                            } else {
                                WhiteAlpha04
                            },
                            fontSize = 30.sp,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(id = dictionary.teamsDictionary(esportMatch.team2)),
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = esportMatch.team2, color = if (!whoWon) {
                                    WhiteAlpha08
                                } else {
                                    WhiteAlpha04
                                }
                            )
                            Text(
                                text = esportMatch.teamScore2, color = if (!whoWon) {
                                    WhiteAlpha08
                                } else {
                                    WhiteAlpha04
                                }
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "BO1",
                            color = WhiteAlpha08,
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }

                }

            }

        }
    }


}
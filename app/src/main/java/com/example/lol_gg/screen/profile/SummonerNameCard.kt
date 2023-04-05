package com.example.lol_gg.screen.home.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lol_gg.Dictionary
import com.example.lol_gg.R
import com.example.lol_gg.data.room.User
import com.example.lol_gg.navigation.BottomNavItem
import com.example.lol_gg.ui.theme.*

@Composable
fun SummonerNameCard(
    user: User,
    navController: NavController,
    downloadSummonerData: (summonerName: String, region: String) -> Unit,
    onClick: (name: User) -> Unit
) {
    val dictionary = Dictionary()
    Card(
        modifier = Modifier.padding(top = 20.dp, start = 15.dp, end = 15.dp),
        elevation = 5.dp,
        backgroundColor = MainBackground2
    ) {
        Column() {
            Column(
                modifier = Modifier.padding(
                    top = 8.dp,
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 8.dp
                )
            ) {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.lol_logo),
                        modifier = Modifier.size(35.dp),
                        contentDescription = ""
                    )
                    Text(
                        text = "League of Legends",
                        color = WhiteAlpha08,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.g2_icon),
                        modifier = Modifier
                            .size(60.dp)
                            .clip(
                                CircleShape
                            ),
                        contentDescription = ""
                    )
                }
                Text(text = "Summoner Name", color = WhiteAlpha01, fontSize = 22.sp)
                Text(
                    text = user.summonerName,
                    color = WhiteAlpha08,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Divider(
                    color = WhiteAlpha01,
                    thickness = 1.dp,
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                )
                Text(text = "SOLO / DUO", color = WhiteAlpha01, fontSize = 22.sp)
                Row() {
                    val tmpRank =
                        stringResource(id = dictionary.rankSmallLettersDictionary(user.summonerTier))
                    Image(
                        painter = painterResource(id = dictionary.rankIconDictionary(user.summonerTier)),
                        modifier = Modifier.size(50.dp),
                        contentDescription = ""
                    )
                    Text(
                        text = "$tmpRank ${user.summonerRank}",
                        color = WhiteAlpha08,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.Delete,
                        tint = WhiteAlpha08,
                        contentDescription = "",
                        modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                onClick(user)
                            }
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(SecondaryColor)
                    .clickable {
                        downloadSummonerData(user.summonerName, user.summonerServer)
                        navController.navigate(BottomNavItem.Home.screen_route)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.match_history),
                    color = WhiteAlpha08,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "",
                    tint = WhiteAlpha04
                )
            }
        }
    }
}

package com.example.lol_gg.screen.home.profile

import androidx.compose.runtime.*
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel,
    downloadSummonerData: (summonerName: String, region: String) -> Unit
) {
    Profile(navController, profileViewModel, downloadSummonerData = downloadSummonerData)

}

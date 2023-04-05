package com.example.lol_gg.screen.home.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lol_gg.R
import com.example.lol_gg.navigation.Screen
import com.example.lol_gg.ui.theme.SettingsIconsColor
import com.example.lol_gg.ui.theme.WhiteAlpha08
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun Profile(navController: NavController, profileViewModel: ProfileViewModel, downloadSummonerData: (summonerName: String, region: String) -> Unit) {
    LaunchedEffect(key1 = true, block = {
        profileViewModel.initialize()
    })
    val listOfSummonerNames = profileViewModel.listOfSummonerNames
    val openAlertDialogSignOut = remember { mutableStateOf(false) }

    if (openAlertDialogSignOut.value) {
        AlertDialog(
            title = stringResource(id = R.string.alert_remove_account_title),
            description = stringResource(
                id = R.string.alert_remove_account_description
            ),
            actionString = stringResource(id = R.string.alert_remove_account_action),
            color = SettingsIconsColor
        ) { value, shouldDeleteAccount ->
            openAlertDialogSignOut.value = value
            if (shouldDeleteAccount) {
                profileViewModel.deleteSummonerName()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Row(modifier = Modifier.padding(top = 20.dp, start = 15.dp, end = 15.dp)) {
            Text(
                text = "Profile",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = WhiteAlpha08
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "",
                tint = WhiteAlpha08,
                modifier = Modifier
                    .size(35.dp)
                    .clickable {
                        navController.navigate(Screen.SettingsScreen.route)
                    }
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            itemsIndexed(
                items = listOfSummonerNames,
                key = { _, item -> item.hashCode() }
            ) { index, item ->
                SummonerNameCard(user = item, navController = navController, downloadSummonerData = downloadSummonerData) {
                    openAlertDialogSignOut.value = true
                    profileViewModel.user = it
                }
            }

            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

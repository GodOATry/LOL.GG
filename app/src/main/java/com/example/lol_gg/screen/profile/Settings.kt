package com.example.lol_gg.screen.home.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lol_gg.R
import com.example.lol_gg.navigation.BottomNavItem
import com.example.lol_gg.ui.theme.SettingsIconsColor
import com.example.lol_gg.ui.theme.WhiteAlpha01
import com.example.lol_gg.ui.theme.WhiteAlpha08
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun Settings(navController: NavController, profileViewModel: ProfileViewModel) {
    val openAlertDialogSignOut = remember { mutableStateOf(false) }

    if (openAlertDialogSignOut.value) {
        AlertDialog(
            title = stringResource(id = R.string.alert_sign_out_title),
            description = stringResource(
                id = R.string.alert_sign_out_description
            ),
            actionString = stringResource(id = R.string.sign_out),
            color = SettingsIconsColor
        ) { value, shouldSignOut ->
            openAlertDialogSignOut.value = value
            if (shouldSignOut) {
                profileViewModel.signOut()
                navController.popBackStack(
                    BottomNavItem.Profile.screen_route,
                    inclusive = false
                )
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding()
    ) {
        Row(Modifier.fillMaxWidth(0.6f)) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = WhiteAlpha08,
                modifier = Modifier.clickable {
                    navController.popBackStack(
                        BottomNavItem.Profile.screen_route,
                        inclusive = false
                    )
                }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.settings),
                color = WhiteAlpha08,
                fontSize = 24.sp
            )
        }
        LazyColumn(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp)) {
            item {
                SettingsItem(
                    name = stringResource(id = R.string.sign_out),
                    icon = Icons.Default.Logout
                ) {
                    openAlertDialogSignOut.value = true
                }
                Divider(
                    color = WhiteAlpha01,
                    thickness = 1.dp,
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                )
            }
        }
    }
}

@Composable
fun SettingsItem(
    name: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = "", tint = SettingsIconsColor)
        Text(
            text = name,
            fontSize = 24.sp,
            color = WhiteAlpha08,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

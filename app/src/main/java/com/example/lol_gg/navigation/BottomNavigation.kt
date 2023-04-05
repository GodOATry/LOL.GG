package com.example.lol_gg.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lol_gg.ui.theme.MainBackground
import com.example.lol_gg.ui.theme.WhiteAlpha04


@Composable
fun BottomNavigationOwn(navController: NavController) {
    val items = listOf(
        BottomNavItem.Profile,
        BottomNavItem.Home,
        BottomNavItem.Calculator,
        BottomNavItem.Esport
    )

    BottomNavigation(
        backgroundColor = MainBackground,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {Icon(imageVector = item.icon, tint = Color.White, contentDescription = null)},
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = Color.White,
                unselectedContentColor = WhiteAlpha04,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
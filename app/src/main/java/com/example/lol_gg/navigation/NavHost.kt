package com.example.lol_gg.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lol_gg.screen.ProfileScreen
import com.example.lol_gg.screen.CalculatorScreen
import com.example.lol_gg.screen.home.HomeScreen
import com.example.lol_gg.screen.home.HomeViewModel
import com.example.lol_gg.screen.home.profile.ProfileViewModel
import com.example.lol_gg.screen.home.profile.Registration


@Composable
fun NavigationGraph(navController: NavHostController) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val profileViewModel:ProfileViewModel = hiltViewModel()
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen(homeViewModel)
        }
        composable(BottomNavItem.Calculator.screen_route) {
            CalculatorScreen()
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileScreen(navController,profileViewModel)
        }
        composable(Screen.RegistrationScreen.route){
            Registration(navController,profileViewModel)
        }
    }
}

sealed class BottomNavItem(var title: String, var icon: ImageVector, var screen_route: String) {
    object Home : BottomNavItem("Home", Icons.Filled.Home, "home")
    object Calculator : BottomNavItem("Calculator", Icons.Filled.Calculate, "my_network")
    object Profile : BottomNavItem("Profile", Icons.Filled.Person, "add_post")
}
sealed class Screen(val route : String){
    object RegistrationScreen : Screen("Registration")

}

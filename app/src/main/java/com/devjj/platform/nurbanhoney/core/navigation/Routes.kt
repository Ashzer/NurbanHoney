package com.devjj.platform.nurbanhoney.core.navigation

sealed class Routes(val route: String) {
    object Splash : Routes("splash_screen")
    object Home : Routes("home_screen")
    object Rank : Routes("rank_screen")
    object Profile : Routes("option_screen")
}
// https://proandroiddev.com/animated-splash-screen-in-android-with-compose-4b7dc1baecc5

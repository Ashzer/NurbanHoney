package com.devjj.platform.nurbanhoney.core.navigation

sealed class Screen(val route: String){
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
}
//https://proandroiddev.com/animated-splash-screen-in-android-with-compose-4b7dc1baecc5
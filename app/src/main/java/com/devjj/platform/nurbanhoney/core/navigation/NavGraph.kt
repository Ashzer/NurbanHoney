package com.devjj.platform.nurbanhoney.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.devjj.platform.nurbanhoney.feature.ui.HomeScreen
import com.devjj.platform.nurbanhoney.feature.ui.ProfileScreen
import com.devjj.platform.nurbanhoney.feature.ui.RankScreen
import com.devjj.platform.nurbanhoney.feature.ui.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Rank.route) {
            RankScreen(navController = navController)
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}

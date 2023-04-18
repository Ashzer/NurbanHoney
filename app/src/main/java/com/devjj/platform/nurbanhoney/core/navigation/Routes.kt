package com.devjj.platform.nurbanhoney.core.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.devjj.platform.nurbanhoney.domain.board.model.Board

sealed class Routes(val route: String) {
	object Splash : Routes(route = "splash")
	object Home : Routes(route = "home"){
		fun createRoute(boards : List<Board>) = "home?boards={$boards}"
	}
	object Article : Routes(route = "article/{board}/{id}") {
		fun createRoute(board: String, id: Int) = "article/$board/$id"
	}

	object Rank : Routes(route = "rank")
	object Profile : Routes(route = "option")
}
// https://proandroiddev.com/animated-splash-screen-in-android-with-compose-4b7dc1baecc5

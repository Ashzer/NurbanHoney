package com.devjj.platform.nurbanhoney.core.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.devjj.platform.nurbanhoney.feature.ui.*
import com.devjj.platform.nurbanhoney.feature.ui.article.ArticlePage
import com.devjj.platform.nurbanhoney.feature.ui.article.ArticleSideEffect
import com.devjj.platform.nurbanhoney.feature.ui.article.ArticleViewModel
import com.devjj.platform.nurbanhoney.feature.ui.home.HomeViewModel
import com.devjj.platform.nurbanhoney.feature.ui.home.HomePage
import com.devjj.platform.nurbanhoney.feature.ui.home.HomeSideEffect
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SetupNavGraph(navController: NavHostController) {
	NavHost(
		navController = navController,
		startDestination = Routes.Splash.route
	) {
		addSplash(navController = navController)
		addHome(navController = navController)
		addArticle(navController = navController)
//        composable(route = Routes.Home.route) {
//            HomeScreen(navController = navController)
//        }
//        composable(route = Routes.Rank.route) {
//            RankScreen(navController = navController)
//        }
//        composable(route = Routes.Profile.route) {
//            ProfileScreen(navController = navController)
//        }
	}
}

fun NavGraphBuilder.addSplash(navController: NavHostController) {
	composable(route = Routes.Splash.route) {
		SplashPage(navController = navController)
	}
}

fun NavGraphBuilder.addHome(navController: NavController) {
	composable(route = Routes.Home.route) {
		val viewModel = hiltViewModel<HomeViewModel>()
		val state by viewModel.collectAsState()

		viewModel.collectSideEffect {
			when (it) {
				is HomeSideEffect.ShowToast -> {
					Toast.makeText(navController.context, it.message, Toast.LENGTH_SHORT).show()
				}
				is HomeSideEffect.ShowArticleDetail -> {
					navController.navigate(route = Routes.Article.createRoute(it.board, it.id))
				}
			}
		}
		HomePage(
			state = state,
			navController = navController,
			onTabSelected = { viewModel.onTabSelected(it) },
			onArticleClicked = { viewModel.onArticleClicked(it) })
	}
}

fun NavGraphBuilder.addArticle(navController: NavController) {
	composable(route = Routes.Article.route) {
		val viewModel = hiltViewModel<ArticleViewModel>()
		val state by viewModel.collectAsState()
		viewModel.collectSideEffect {
			when (it) {
				is ArticleSideEffect.ShowToast -> {
					Toast.makeText(navController.context, it.message, Toast.LENGTH_SHORT).show()
				}
			}
		}
		ArticlePage(state = state, navController = navController)
	}
}

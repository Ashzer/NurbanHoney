package com.devjj.platform.nurbanhoney.feature.ui.rank

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.devjj.platform.nurbanhoney.core.extension.AlignLeft
import com.devjj.platform.nurbanhoney.core.extension.AlignRight
import com.devjj.platform.nurbanhoney.core.platform.DrawBottomNavigation
import com.devjj.platform.nurbanhoney.core.platform.DrawerContent
import com.devjj.platform.nurbanhoney.core.platform.MainToolBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RankPage(state: RankState, navController: NavController) {
	val scaffoldState = rememberScaffoldState()
	val coroutineScope = rememberCoroutineScope()
	val contextForToast = LocalContext.current.applicationContext
	val drawerState = scaffoldState.drawerState
	AlignRight {
		MaterialTheme {
			Scaffold(
				scaffoldState = scaffoldState,
				backgroundColor = Color.Blue,

				// Align left
				topBar = {
					AlignLeft {
						MainToolBar(scaffoldState.drawerState, coroutineScope)
					}
				},
				bottomBar = {
					AlignLeft {
						DrawBottomNavigation(navController)
					}
				},
				content = { paddingValues ->
					AlignLeft {
						Box {
							TextField(value = "rank screen $paddingValues", onValueChange = {})
						}
					}
				},
				drawerContent = {
					AlignLeft {
						DrawerContent { itemLabel ->
							Toast
								.makeText(contextForToast, itemLabel, Toast.LENGTH_SHORT)
								.show()
							coroutineScope.launch {
								// delay for the ripple effect
								delay(timeMillis = 250)
								drawerState.close()
							}
						}
					}
				}
			)
		}
	}
}

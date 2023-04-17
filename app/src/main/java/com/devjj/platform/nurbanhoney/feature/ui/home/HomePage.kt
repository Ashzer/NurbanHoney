package com.devjj.platform.nurbanhoney.feature.ui.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devjj.platform.nurbanhoney.core.extension.AlignLeft
import com.devjj.platform.nurbanhoney.core.extension.AlignRight
import com.devjj.platform.nurbanhoney.core.platform.DrawBottomNavigation
import com.devjj.platform.nurbanhoney.core.platform.DrawerContent
import com.devjj.platform.nurbanhoney.core.platform.MainToolBar
import com.devjj.platform.nurbanhoney.feature.ui.BoardsTab
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomePage(
	state: HomeState,
	navController: NavController,
	onTabSelected: (Int) -> Unit,
	onArticleClicked: (Int) -> Unit
) {
	val scaffoldState = rememberScaffoldState()
	val coroutineScope = rememberCoroutineScope()
	val context = LocalContext.current.applicationContext
	val drawerState = scaffoldState.drawerState

	AlignRight {
		MaterialTheme {
			Scaffold(
				scaffoldState = scaffoldState,
				backgroundColor = Color.Transparent,

				// Align left
				topBar = {
					MainTopBar(state) {
						onTabSelected(it)
					}
				},
				bottomBar = {
					AlignLeft {
						DrawBottomNavigation(
							navController
						)
					}
				},
				content = { paddingValues ->
					AlignLeft {
						// MainDrawer(scaffoldState.drawerState)
						Column {
							LazyRow() {
								items(500) {
									Card(
										modifier = Modifier
											.padding(
												5.dp
											)
											.width(200.dp)
											.height(120.dp),
										backgroundColor = Color(
											0x33F6B748
										),
										shape = RoundedCornerShape(
											30.dp
										)
									) {}
								}
							}

							LazyColumn(content = {
								state.articlePreviews?.let { previews ->
									items(previews.size) {
										ArticlePreview(previews[it]) { index ->
											onArticleClicked(index)
											Log.d("articles", "at id = $index has clicked")
										}
									}
								}
							})
						}
						paddingValues.calculateTopPadding()
					}
				},
				drawerContent = {
					AlignLeft {
						DrawerContent { itemLabel ->
							Toast.makeText(
								context,
								itemLabel,
								Toast.LENGTH_SHORT
							).show()
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

@Composable
fun MainTopBar(
	state: HomeState,
	onTabSelected: (Int) -> Unit
) {
	val scaffoldState = rememberScaffoldState()
	val coroutineScope = rememberCoroutineScope()

	if (!state.boards.isNullOrEmpty()) {
		Log.d(
			"Tap",
			"MainTopBar ${state.boards} : ${state.selectedBoardIndex}"
		)
	} else {
		Log.d("Tap", "MainTopBar empty boards")
	}

	Column {
		AlignLeft {
			MainToolBar(
				scaffoldState.drawerState,
				coroutineScope
			)
		}
		AlignLeft {
			BoardsTab(state) { onTabSelected(it) }
		}
	}
}
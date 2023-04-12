package com.devjj.platform.nurbanhoney.feature.ui

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.devjj.platform.nurbanhoney.core.extension.AlignLeft
import com.devjj.platform.nurbanhoney.core.extension.AlignRight
import com.devjj.platform.nurbanhoney.core.platform.DrawBottomNavigation
import com.devjj.platform.nurbanhoney.core.platform.DrawerContent
import com.devjj.platform.nurbanhoney.core.platform.MainToolBar
import com.devjj.platform.nurbanhoney.domain.board.model.Board
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavHostController,
    boardViewModel: BoardViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val contextForToast =
        LocalContext.current.applicationContext
    val drawerState = scaffoldState.drawerState

    val boards by boardViewModel.boardsState.collectAsState()
    boardViewModel.getBoards()
    boardViewModel.getArticle()
    val articles by boardViewModel.articlesState.collectAsState()
    Log.d("viewmodel_check", boardViewModel.toString())
    Log.d("Tap", "HomeScreen $boards")
    AlignRight {
        MaterialTheme {
            Scaffold(
                scaffoldState = scaffoldState,
                backgroundColor = Color.Transparent,

                // Align left
                topBar = {
                    MainTopBar(boards)
                },
                bottomBar = {
                    AlignLeft {
                        DrawBottomNavigation(navController)
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
                                            .padding(5.dp)
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
                                items(articles.size) {
                                    ArticleItem(articles[it]) { index ->
                                        Log.d("articles", "at id = $index has clicked")
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
                                contextForToast,
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
fun MainTopBar(boards: List<Board>) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    if (boards.isNotEmpty()) {
        Log.d("Tap", "MainTopBar $boards : ${boards[0]}")
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
            var selectedTabIndex by remember {
                mutableStateOf(
                    0
                )
            }

            BoardsTab(
                tabs = boards,
                selectedTabIndex = selectedTabIndex
            ) { tabIndex ->
                selectedTabIndex = tabIndex
            }
        }
    }
}

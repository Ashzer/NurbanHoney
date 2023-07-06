package com.devjj.platform.nurbanhoney.feature.ui.home

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devjj.platform.nurbanhoney.R
import com.devjj.platform.nurbanhoney.core.extension.alignRight
import com.devjj.platform.nurbanhoney.core.platform.*
import com.devjj.platform.nurbanhoney.feature.ui.BoardsTab
import kotlinx.coroutines.CoroutineScope
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
                DrawBottomNavigation(
                    navController
                )

            },
            content = { paddingValues ->
                // MainDrawer(scaffoldState.drawerState)
                Column {
                    LazyRow() {
                        items(500) {
                            Card(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .width(200.dp)
                                    .height(120.dp),
                                backgroundColor = Color(0x33F6B748),
                                shape = RoundedCornerShape(30.dp)
                            ) {}
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        LazyColumn(content = {
                            state.articlePreviews?.let { previews ->
                                items(previews.size) {
                                    ArticlePreview(previews[it]) { index ->
                                        onArticleClicked(index)
                                    }
                                }
                            }
                        })

                        when (state.state) {
                            is HomeUiState.ArticlePreviewsLoading -> {
                                LoadingIndicator(modifier = Modifier.fillMaxSize())
                            }
                            is HomeUiState.Failed -> {
                                ErrorMessage(
                                    message = state.state.message,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            else -> Unit
                        }
                    }

                }
                paddingValues.calculateTopPadding()

            },
            drawerContent = alignRight{
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

            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.write),
                        contentDescription = null
                    )
                }
            }
        )

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
        MainToolBar(
            scaffoldState.drawerState,
            coroutineScope
        )
        BoardsTab(state) { onTabSelected(it) }

    }
}

@Composable
fun BasePage(
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    navController: NavController,
    drawerState: DrawerState,
    context: Context,
    content: @Composable () -> Unit
) {
    MaterialTheme {
        Scaffold(
            scaffoldState = scaffoldState,
            backgroundColor = Color.Blue,

            // Align left
            topBar = {
                MainToolBar(scaffoldState.drawerState, coroutineScope)
            },
            bottomBar = {
                DrawBottomNavigation(navController)

            },
            content = {
                it
            },
            drawerContent = {
                DrawerContent { itemLabel ->
                    Toast
                        .makeText(context, itemLabel, Toast.LENGTH_SHORT)
                        .show()
                    coroutineScope.launch {
                        // delay for the ripple effect
                        delay(timeMillis = 250)
                        drawerState.close()
                    }
                }
            }
        )
    }
}

package com.devjj.platform.nurbanhoney.feature.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.textButtonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.devjj.platform.nurbanhoney.core.extension.AlignLeft
import com.devjj.platform.nurbanhoney.core.extension.AlignRight
import com.devjj.platform.nurbanhoney.core.platform.DrawBottomNavigation
import com.devjj.platform.nurbanhoney.core.platform.DrawerContent
import com.devjj.platform.nurbanhoney.core.platform.MainToolBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val contextForToast = LocalContext.current.applicationContext
    val drawerState = scaffoldState.drawerState
    val scope = coroutineScope

    AlignRight {
        MaterialTheme {
            Scaffold(
                scaffoldState = scaffoldState,
                backgroundColor = Color.Transparent,

                //Align left
                topBar = {
                    Column {
                        AlignLeft {
                            MainToolBar(scaffoldState.drawerState, coroutineScope)
                        }
                        AlignLeft {
                            var selectedTabIndex by remember { mutableStateOf(0) }
                            val tabs = listOf(
                                "전체",
                                "인기",
                                "너반꿀",
                                "자유",
                                "음악",
                                "스포츠"
                            )
                            BoardsTab(
                                tabs = tabs,
                                selectedTabIndex = selectedTabIndex,
                            ) { tabIndex ->
                                selectedTabIndex = tabIndex
                            }
                        }

                    }
                },
                bottomBar = {
                    AlignLeft {
                        DrawBottomNavigation(navController)
                    }
                },
                content = { paddingValues ->
                    AlignLeft {
                        //MainDrawer(scaffoldState.drawerState)
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
                                    ) {
                                    }
                                }
                            }


                            LazyColumn(content = {
                                items(500) {
                                    Button(
                                        onClick = { /*TODO*/ },
                                        modifier = Modifier
                                            .padding(5.dp)
                                            .height(100.dp)
                                            .fillMaxWidth()
                                    ) {
                                        Text("ddddddd")
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


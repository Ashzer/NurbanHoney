package com.devjj.platform.nurbanhoney.feature.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
                backgroundColor = Color.Blue,

                //Align left
                topBar = {
                    Column {
                        AlignLeft {
                            MainToolBar(scaffoldState.drawerState, coroutineScope)
                        }
                        AlignLeft {
                            var selectedTabIndex by remember { mutableStateOf(0)}
                            val tabs = listOf(
                                "Button1",
                                "Button2",
                                "LongButton3",
                                "Button4",
                                "Button5",
                                "LongButton6",
                                "Button7"
                            )
                            BoardsTab(tabs = tabs, selectedTabIndex =  selectedTabIndex){ tabIndex->
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
                        Column() {
                            Button(onClick = { /*TODO*/ }) {
                                Text("ddddddd")
                            }
                            Button(onClick = { /*TODO*/ }) {
                                Text("ddddddd")
                            }
                            Button(onClick = { /*TODO*/ }) {
                                Text("ddddddd")
                            }
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

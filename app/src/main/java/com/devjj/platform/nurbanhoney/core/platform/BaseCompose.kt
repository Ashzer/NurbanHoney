package com.devjj.platform.nurbanhoney.core.platform

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devjj.platform.nurbanhoney.R
import com.devjj.platform.nurbanhoney.core.extension.AlignLeft
import com.devjj.platform.nurbanhoney.core.navigation.Routes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainToolBar(drawerState: DrawerState, scope: CoroutineScope) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.ic_appbar_title),
                contentDescription = null,
                modifier = Modifier.offset(x = (-20).dp)
            )
        },
        navigationIcon = {
            IconButton(
                content = {
                    Image(
                        painter = painterResource(
                            id = R.drawable.ic_appbar_icon
                        ),
                        contentDescription = null
                    )
                },
                onClick = {}
            )
        },
        actions = {
            IconButton(
                content = {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "drawer",
                        tint = Color.Black
                    )
                },
                onClick = {
                    scope.launch { if (drawerState.isOpen) drawerState.close() else drawerState.open() }
                }
            )
        }
    )
}

@Composable
fun DrawerContent(
    itemClick: (String) -> Unit
) {
    Column() {
        AlignLeft {
            Button(
                onClick = { itemClick("Drawer Closing") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Close drawer")
            }
            Button(onClick = {}) {
                Text("Button2")
            }
        }
    }
}

@Composable
fun DrawBottomNavigation(navController: NavController) {
    BottomAppBar(modifier = Modifier.border(width = 1.dp, color = Color(0xFFD5D5D5))) {
        BottomNavigationItem(
            selected = true,
            onClick = {
                with(Routes.Home.route) {
                    navController.clearBackStack(this)
                    navController.navigate(this) { launchSingleTop = true }
                }
            },
            icon = {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_menu_home
                    ),
                    contentDescription = null
                )
            }
        )
        BottomNavigationItem(
            selected = true,
            onClick = {
                with(Routes.Rank.route) {
                    navController.clearBackStack(this)
                    navController.navigate(this) { launchSingleTop = true }
                }
            },
            icon = {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_menu_ranking
                    ),
                    contentDescription = null
                )
            }
        )
        BottomNavigationItem(
            selected = true,
            onClick = {
                with(Routes.Profile.route) {
                    navController.clearBackStack(this)
                    navController.navigate(this) { launchSingleTop = true }
                }
            },
            icon = {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_menu_profile
                    ),
                    contentDescription = null
                )
            }
        )
    }
}

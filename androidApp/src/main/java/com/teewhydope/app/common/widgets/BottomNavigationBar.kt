package com.teewhydope.app.common.widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.teewhydope.app.common.di.BottomNavigationBarDependencies
import com.teewhydope.app.ui.character.screen.People
import com.teewhydope.app.ui.character.screen.PersonDetailScreen
import com.teewhydope.app.ui.route.People
import com.teewhydope.app.ui.route.PersonDetail
import com.teewhydope.app.ui.route.Starships

@Composable
fun BottomNavigationBarDependencies.BottomNavigationBar() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
                    NavigationBarItem(
                        selected = navigationItem.route == currentDestination?.route,
                        label = {
                            Text(navigationItem.label)
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues = paddingValues),
            navController = navController,
            startDestination = People
        ) {
            composable<People> {
                peopleScreenDependencies.People(navController)
            }
            composable<PersonDetail> { backStackEntry ->
                val detail: PersonDetail = backStackEntry.toRoute()
                personDetailDependencies.PersonDetailScreen(detail.id, navController)
            }
            composable<Starships> {
                Text(text = "Starships")
            }
        }
    }
}
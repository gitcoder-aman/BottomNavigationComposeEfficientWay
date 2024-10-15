package com.tech.bottomnavigationefficientway.navigtion.bottomNavigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tech.bottomnavigationefficientway.navigtion.HomeScreen
import com.tech.bottomnavigationefficientway.navigtion.NavGraph
import com.tech.bottomnavigationefficientway.navigtion.ProfileScreen
import com.tech.bottomnavigationefficientway.navigtion.SearchScreen

@Composable
fun MedicalNavigator() {

    val bottomNavigationItems = listOf(
        BottomNavigationItem(
            text = "Home",
            icon = Icons.Default.Home,
        ),
        BottomNavigationItem(
            text = "Search",
            icon = Icons.Default.Search,
        ),
        BottomNavigationItem(
            text = "Profile",
            icon = Icons.Default.Person,
        )
    )
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    // Update selectedItem based on backStackEntry
    if (backStackEntry.value != null) {
        selectedItem = when (backStackEntry.value?.destination?.route) {
            HomeScreen.route -> 0
            SearchScreen.route -> 1
            ProfileScreen.route -> 2
            else -> 0
        }
    }
    // Update selectedItem based on backStackEntry
    backStackEntry.value?.let { entry ->
        selectedItem = when (entry.destination.route) {
            HomeScreen.route -> 0
            SearchScreen.route -> 1
            ProfileScreen.route -> 2
            else -> 0
        }
    }
    val isBottomBarVisible = backStackEntry.value?.destination?.route in listOf(
        HomeScreen.route,
        SearchScreen.route,
        ProfileScreen.route
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                MedicalBottomNavigation(
                    items = bottomNavigationItems,
                    selected = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTab(
                                navController = navController,
                                route = HomeScreen.route
                            )

                            1 -> navigateToTab(
                                navController = navController,
                                route = SearchScreen.route
                            )

                            2 -> navigateToTab(
                                navController = navController,
                                route = ProfileScreen.route
                            )
                        }
                    }
                )
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavGraph(navController, bottomPadding)
    }

}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}
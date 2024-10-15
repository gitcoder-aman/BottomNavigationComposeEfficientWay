package com.tech.bottomnavigationefficientway.navigtion

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tech.bottomnavigationefficientway.screens.HomeScreen
import com.tech.bottomnavigationefficientway.screens.NextScreen
import com.tech.bottomnavigationefficientway.screens.OtherScreen
import com.tech.bottomnavigationefficientway.screens.ProfileScreen
import com.tech.bottomnavigationefficientway.screens.SearchScreen

@Composable
fun NavGraph(navController: NavHostController, bottomPadding: Dp) {

    NavHost(
        navController = navController,
        startDestination = HomeScreen.route,
        modifier = Modifier.padding(bottom = bottomPadding)
    ){
        composable(HomeScreen.route) {
            HomeScreen(navController)
        }
        composable("others/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            if (userId != null) {
                OtherScreen(navController,userId)
            }
        }
        composable(ProfileScreen.route) {
            ProfileScreen()
        }
        composable(SearchScreen.route) {
            SearchScreen(navController)
        }
        composable(NextScreen.route) {
            NextScreen()
        }
    }

}
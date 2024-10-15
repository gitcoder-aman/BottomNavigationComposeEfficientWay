package com.tech.bottomnavigationefficientway.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.tech.bottomnavigationefficientway.navigtion.OtherScreen

@Composable
fun SearchScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Search Screen")
        Button(
            onClick = {
                navController.navigate(OtherScreen("User@12345").route)
            }
        ) {
            Text("Navigate other screen ")
        }
    }


}
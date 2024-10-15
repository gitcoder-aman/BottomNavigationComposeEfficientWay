package com.tech.bottomnavigationefficientway.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.tech.bottomnavigationefficientway.navigtion.NextScreen

@Composable
fun OtherScreen(navController: NavController, userId: String) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "other Screen")

        Button(
            onClick = {
                navController.navigate(NextScreen.route)
            }
        ) {
            Text("Navigate next screen $userId")
        }

    }


}
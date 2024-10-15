package com.tech.bottomnavigationefficientway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tech.bottomnavigationefficientway.navigtion.NavGraph
import com.tech.bottomnavigationefficientway.navigtion.bottomNavigation.MedicalNavigator
import com.tech.bottomnavigationefficientway.ui.theme.BottomNavigationEfficientWayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavigationEfficientWayTheme {
                MedicalNavigator()
            }

        }
    }
}

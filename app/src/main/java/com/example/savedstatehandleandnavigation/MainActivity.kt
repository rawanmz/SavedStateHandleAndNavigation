package com.example.savedstatehandleandnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.savedstatehandleandnavigation.navigation.NavigationGraph
import com.example.savedstatehandleandnavigation.ui.theme.SavedStateHandleAndNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SavedStateHandleAndNavigationTheme {
                NavigationGraph()
            }
        }
    }
}
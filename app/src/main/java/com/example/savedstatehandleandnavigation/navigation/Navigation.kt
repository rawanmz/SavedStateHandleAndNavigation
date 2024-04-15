package com.example.savedstatehandleandnavigation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun NavigationGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screens.HomeScreen) {
        composable(Screens.HomeScreen) {
            ScreenA(it, navController)
        }
        composable(
            "${Screens.SecondScreen}/{userId}", arguments =
            listOf(navArgument("userId") {
                type = NavType.StringType
            })
        ) {
            ScreenB(navController, it)
        }
        composable(Screens.ThirddScreen) {
            ScreenC()
        }
    }
}

@Composable
private fun ScreenC() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(text = Screens.ThirddScreen)
    }
}

@Composable
private fun ScreenB(
    navController: NavHostController,
    it: NavBackStackEntry
) {
    navController.previousBackStackEntry?.savedStateHandle?.set(
        "text1",
        " test text value "
    )
    val receivedArgument = it.arguments?.getString("userId")
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .clickable {
                navController.navigate(Screens.ThirddScreen)
            }
    ) {
        Text(text = Screens.SecondScreen.plus(receivedArgument))
    }
}

@Composable
private fun ScreenA(
    it: NavBackStackEntry,
    navController: NavHostController
) {
    val text = it.savedStateHandle.get<String>("text1")
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Red)
            .clickable {
                val x= "user id is 1112233"
                navController.navigate("${Screens.SecondScreen}/$x")
            }
    ) {
        Text(text = Screens.HomeScreen.plus(text.orEmpty()))
    }
}
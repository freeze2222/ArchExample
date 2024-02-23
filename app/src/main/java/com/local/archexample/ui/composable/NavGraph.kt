package com.local.archexample.ui.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.local.archexample.data.utils.NavDestinations
import com.local.archexample.ui.screens.main.MainScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavDestinations.FIRST_SCREEN) {
        composable(route = NavDestinations.FIRST_SCREEN){
            MainScreen()
        }
    }
}
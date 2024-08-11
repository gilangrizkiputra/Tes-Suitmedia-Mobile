package com.tes.androidtessuitmedia.ui.screen.firstScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tes.androidtessuitmedia.ui.navigation.Screen

fun NavGraphBuilder.firstScreenRoute(navController: NavController){
    composable(route = Screen.FirstScreen.route){
        FirstScreen(navController)
    }
}
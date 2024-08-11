package com.tes.androidtessuitmedia.ui.screen.secondScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tes.androidtessuitmedia.ui.navigation.Screen
import com.tes.androidtessuitmedia.ui.screen.firstScreen.FirstScreen

fun NavGraphBuilder.secondScreenRoute(navController: NavController){
    composable(
        route = Screen.SecondScreen.route,
        arguments = listOf(navArgument("userName"){type = NavType.StringType})
        ){ backStackEntry ->
        val userName = backStackEntry.arguments?.getString("userName") ?: "User Name"
        SecondScreen(navController, userName = userName)
    }
}
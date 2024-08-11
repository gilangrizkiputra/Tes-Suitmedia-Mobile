package com.tes.androidtessuitmedia.ui.screen.thirdScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tes.androidtessuitmedia.ui.navigation.Screen
import com.tes.androidtessuitmedia.ui.screen.firstScreen.FirstScreen

fun NavGraphBuilder.thirdScreenRoute(navController: NavController){
    composable(route = Screen.ThirdScreen.route){
        ThirdScreen(navController)
    }
}
package com.tes.androidtessuitmedia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tes.androidtessuitmedia.ui.screen.firstScreen.firstScreenRoute
import com.tes.androidtessuitmedia.ui.screen.secondScreen.secondScreenRoute
import com.tes.androidtessuitmedia.ui.screen.thirdScreen.thirdScreenRoute

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.FirstScreen.route,
        modifier = modifier
    ) {
        firstScreenRoute(navController)
        secondScreenRoute(navController)
        thirdScreenRoute(navController)
    }
}
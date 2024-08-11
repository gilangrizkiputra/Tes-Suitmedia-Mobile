package com.tes.androidtessuitmedia

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tes.androidtessuitmedia.ui.navigation.AppNavGraph

@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    AppNavGraph(navController = navController, modifier = modifier)
}
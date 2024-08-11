package com.tes.androidtessuitmedia.ui.navigation

sealed class Screen(val route: String){
    data object FirstScreen: Screen("firstScreen")
    data object SecondScreen: Screen("secondScreen/{userName}"){
        fun createRoute(userName: String) = "secondScreen/$userName"
    }
    data object ThirdScreen: Screen("thirdScreen")
}
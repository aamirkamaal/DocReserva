package com.example.docreserva.ui.theme

sealed class Screen(val route: String) {
    object Splash: Screen("main_screen")

    object Login: Screen("detail_screen")
}
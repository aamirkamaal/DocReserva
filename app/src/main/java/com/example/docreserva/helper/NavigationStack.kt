package com.example.docreserva.helper


import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.docreserva.ui.theme.Screen
import com.example.docreserva.ui.theme.activity.LoginView
import com.example.docreserva.ui.theme.activity.SplashScreenView

@Composable
fun NavigationStack(context: Context) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreenView(navController = navController)
        }
        composable(
            route = Screen.Splash.route,
            arguments = listOf(
                navArgument("text") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            LoginView(context)
        }
    }
}
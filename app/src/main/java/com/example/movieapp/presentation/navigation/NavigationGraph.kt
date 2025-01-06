package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp.presentation.screens.home.view.HomeScreen
import com.example.movieapp.presentation.screens.login.view.LoginScreen
import com.example.movieapp.presentation.screens.register.view.RegisterScreen
import com.example.movieapp.presentation.screens.settings.view.SettingsScreen
import com.example.movieapp.presentation.screens.splash.view.SplashScreen

@Composable
fun NavigationGraph(
    navigationController: NavHostController,
    onBottomBarVisibilityChange: (Boolean) -> Unit
) {
    NavHost(
        navigationController,
        startDestination = MovieAppRoutes.SplashScreen,
    ) {
        composable<MovieAppRoutes.SplashScreen> {
            onBottomBarVisibilityChange(false)
            SplashScreen(navigationController)
        }
        composable<MovieAppRoutes.LoginScreen> {
            onBottomBarVisibilityChange(false)
            LoginScreen(navigationController)
        }
        composable<MovieAppRoutes.RegisterScreen> {
            onBottomBarVisibilityChange(false)
            RegisterScreen(navigationController)
        }
        composable<MovieAppRoutes.HomeScreen> {
            onBottomBarVisibilityChange(true)
            HomeScreen()
        }
        composable<MovieAppRoutes.SettingsScreen> {
            onBottomBarVisibilityChange(true)
            SettingsScreen(navigationController)
        }
    }
}
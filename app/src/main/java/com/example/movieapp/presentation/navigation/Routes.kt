package com.example.movieapp.presentation.navigation

import kotlinx.serialization.Serializable


sealed class MovieAppRoutes() {
    @Serializable
    data object HomeScreen : MovieAppRoutes()

    @Serializable
    data object SettingsScreen : MovieAppRoutes()

    @Serializable
    data object SplashScreen : MovieAppRoutes()

    @Serializable
    data object LoginScreen : MovieAppRoutes()

    @Serializable
    data object RegisterScreen : MovieAppRoutes()
}
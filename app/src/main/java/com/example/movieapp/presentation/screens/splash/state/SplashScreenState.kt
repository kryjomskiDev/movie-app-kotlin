package com.example.movieapp.presentation.screens.splash.state

sealed class  SplashScreenState {
    data object Authenticated : SplashScreenState()

    data object UnAuthenticated : SplashScreenState()
}
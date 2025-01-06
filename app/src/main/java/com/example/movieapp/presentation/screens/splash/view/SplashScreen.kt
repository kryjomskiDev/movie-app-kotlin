package com.example.movieapp.presentation.screens.splash.view

import android.graphics.Movie
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.example.movieapp.presentation.navigation.MovieAppRoutes
import com.example.movieapp.presentation.screens.splash.state.SplashScreenState
import com.example.movieapp.presentation.screens.splash.viewmodel.SplashScreenViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SplashScreen(
    navigationController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<SplashScreenViewModel>()
    val lifecycle = LocalLifecycleOwner.current.lifecycle


    LaunchedEffect(Unit) {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.splashEventState.collect {
                when (it) {
                    is SplashScreenState.Authenticated -> navigationController.navigate(
                        MovieAppRoutes.HomeScreen
                    ) {
                        navigationController.popBackStack()
                    }

                    is SplashScreenState.UnAuthenticated ->
                        navigationController.navigate(MovieAppRoutes.LoginScreen) {
                            navigationController.popBackStack()

                        }
                }
            }
        }
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}
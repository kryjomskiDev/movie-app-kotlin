package com.example.movieapp.presentation.screens.settings.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.movieapp.R
import com.example.movieapp.presentation.components.ErrorBody
import com.example.movieapp.presentation.navigation.MovieAppRoutes
import com.example.movieapp.presentation.screens.settings.state.SettingsScreenState
import com.example.movieapp.presentation.screens.settings.viewmodel.SettingsViewModel
import com.example.movieapp.style.theme.Dimens

@Composable
fun SettingsScreen(
    navigationController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<SettingsViewModel>()
    val state = viewModel.uiState.collectAsState()

    LaunchedEffect(state.value) {
        when (state.value) {
            is SettingsScreenState.LogoutSuccess -> {
                navigationController.navigate(MovieAppRoutes.SplashScreen) {
                    navigationController.popBackStack()
                }
            }

            else -> {}
        }
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(Dimens.m)
    ) {
        Text(
            stringResource(R.string.settings),
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(Modifier.height(Dimens.m))
        when (state.value) {
            is SettingsScreenState.Loaded -> SettingsLoadedBody(
                email = (state.value as SettingsScreenState.Loaded).email,
                onLogoutTap = { viewModel.logout() }
            )

            is SettingsScreenState.Loading -> Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            is SettingsScreenState.Error -> ErrorBody(
                onClick = { viewModel.getUserData() },
                modifier = Modifier.fillMaxSize()
            )

            else -> Box {}
        }
    }
}

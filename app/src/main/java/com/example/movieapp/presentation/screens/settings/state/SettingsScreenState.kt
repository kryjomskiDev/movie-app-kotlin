package com.example.movieapp.presentation.screens.settings.state

sealed interface SettingsScreenState {
    data object  Loading : SettingsScreenState

    data class  Loaded(
        val email : String
    ) : SettingsScreenState

    data object  LogoutSuccess : SettingsScreenState

    data object  Error : SettingsScreenState
}
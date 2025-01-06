package com.example.movieapp.presentation.screens.settings.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.auth.usecase.GetCurrentUserEmailUseCase
import com.example.movieapp.domain.auth.usecase.LogoutUseCase
import com.example.movieapp.presentation.screens.settings.state.SettingsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase,
    private val getCurrentUserEmailUseCase: GetCurrentUserEmailUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<SettingsScreenState>(SettingsScreenState.Loading)
    val uiState = _uiState.asStateFlow()
    private var userEmail  = ""

    init {
        getUserData()
    }

    fun getUserData() {
        try {
            userEmail = getCurrentUserEmailUseCase() ?: ""
            _uiState.value = SettingsScreenState.Loaded(userEmail)
        } catch (error: Exception){
            _uiState.value = SettingsScreenState.Error
        }
    }


    fun logout() {
            try {
                _uiState.value = SettingsScreenState.Loading
                logoutUseCase()
                _uiState.value = SettingsScreenState.LogoutSuccess

            } catch (error: Exception){
                _uiState.value = SettingsScreenState.Error
            }
        }
}
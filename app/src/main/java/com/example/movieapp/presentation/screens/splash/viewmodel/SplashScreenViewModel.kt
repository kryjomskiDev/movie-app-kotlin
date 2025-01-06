package com.example.movieapp.presentation.screens.splash.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.auth.usecase.IsUserSignedInUseCase
import com.example.movieapp.presentation.screens.splash.state.SplashScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val isUserSignedInUseCase: IsUserSignedInUseCase
) : ViewModel() {
    private val _splashEventState = MutableSharedFlow<SplashScreenState>(replay = 1)
    val splashEventState = _splashEventState.asSharedFlow()

    init {
        viewModelScope.launch {
            _splashEventState.emit(
                if (isUserSignedInUseCase()) SplashScreenState.Authenticated else SplashScreenState.UnAuthenticated
            )
        }
    }

}
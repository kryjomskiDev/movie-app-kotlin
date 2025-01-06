package com.example.movieapp.presentation.screens.shared

import com.example.movieapp.domain.validation.FailedValidation

data class AuthUIState(
    val failedValidations: MutableMap<AuthFields, FailedValidation?> = mutableMapOf(),
    val canProceed: Boolean = false,
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = ""
)

enum class AuthFields {
    Email,
    Password
}

sealed class AuthEvent {
    data object Success : AuthEvent()

    data object Error : AuthEvent()
}
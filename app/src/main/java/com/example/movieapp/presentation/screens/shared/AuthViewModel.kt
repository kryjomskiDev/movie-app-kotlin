package com.example.movieapp.presentation.screens.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.auth.usecase.CreateAccountUseCase
import com.example.movieapp.domain.auth.usecase.LoginUseCase
import com.example.movieapp.domain.validation.FailedValidation
import com.example.movieapp.domain.validation.model.validators.EmailValidator
import com.example.movieapp.domain.validation.model.validators.PasswordValidator
import com.example.movieapp.domain.validation.usecase.ValidateTextFieldUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val createAccountUseCase: CreateAccountUseCase,
    private val validateTextFieldUseCase: ValidateTextFieldUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AuthUIState())
    val uiState = _uiState.asStateFlow()

    private val _authEventFlow = MutableSharedFlow<AuthEvent>()
    val authEventFlow = _authEventFlow.asSharedFlow()

    private var canProceed = false
    private var email = ""
    private var password = ""
    private val failedValidations: MutableMap<AuthFields, FailedValidation?> =
        mutableMapOf()

    fun authenticate(isLogin: Boolean) {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }
                if (isLogin) loginUseCase(email, password) else createAccountUseCase(
                    email,
                    password
                )
                _authEventFlow.emit(AuthEvent.Success)
            } catch (error: Exception) {
                _authEventFlow.emit(AuthEvent.Error)
                _uiState.update { it.copy(isLoading = false) }
            }

        }
    }

    fun validateEmail(email: String) {
        failedValidations[AuthFields.Email] = validateTextFieldUseCase(
            value = email,
            validators = listOf(EmailValidator())
        )

        this.email = email
        canProceed = canFormProceed()

        _uiState.update {
            it.copy(
                failedValidations = failedValidations,
                canProceed = canProceed,
                email = email,
            )
        }
    }

    fun validatePassword(password: String) {
        failedValidations[AuthFields.Password] = validateTextFieldUseCase(
            value = password,
            validators = listOf(PasswordValidator())
        )

        this.password = password
        canProceed = canFormProceed()


        _uiState.update {
            it.copy(
                failedValidations = failedValidations,
                canProceed = canProceed,
                password = password
            )
        }
    }

    private fun canFormProceed(): Boolean {
        if (email.isEmpty() || password.isEmpty()) {
            return false
        }

        return failedValidations.filter { it.value != null }.isEmpty()
    }
}
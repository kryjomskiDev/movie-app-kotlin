package com.example.movieapp.domain.auth.usecase

import com.example.movieapp.domain.auth.repository.AuthRepository

class CreateAccountUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ) = authRepository.createAccount(
        email = email,
        password = password
    )
}
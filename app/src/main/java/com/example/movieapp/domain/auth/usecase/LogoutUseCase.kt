package com.example.movieapp.domain.auth.usecase

import com.example.movieapp.domain.auth.repository.AuthRepository

class LogoutUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke() = authRepository.logout()
}
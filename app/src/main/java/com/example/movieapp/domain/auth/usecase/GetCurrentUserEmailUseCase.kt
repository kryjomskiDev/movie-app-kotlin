package com.example.movieapp.domain.auth.usecase

import com.example.movieapp.domain.auth.repository.AuthRepository

class GetCurrentUserEmailUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke() : String? = authRepository.getCurrentUserEmail()
}
package com.example.movieapp.domain.auth.usecase

import com.example.movieapp.domain.auth.repository.AuthRepository

class IsUserSignedInUseCase(
    private  val authRepository: AuthRepository
) {
    operator fun invoke() = authRepository.isUserSignedIn()
}
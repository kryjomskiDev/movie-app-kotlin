package com.example.movieapp.domain.auth.di

import com.example.movieapp.domain.auth.repository.AuthRepository
import com.example.movieapp.domain.auth.usecase.CreateAccountUseCase
import com.example.movieapp.domain.auth.usecase.GetCurrentUserEmailUseCase
import com.example.movieapp.domain.auth.usecase.IsUserSignedInUseCase
import com.example.movieapp.domain.auth.usecase.LoginUseCase
import com.example.movieapp.domain.auth.usecase.LogoutUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AuthUseCasesModule {
    @Provides
    fun provideIsUserSignedInUseCase(authRepository: AuthRepository) = IsUserSignedInUseCase(authRepository)

    @Provides
    fun provideCreateAccountUseCase(authRepository: AuthRepository) = CreateAccountUseCase(authRepository)

    @Provides
    fun provideLogoutUseCase(authRepository: AuthRepository) = LogoutUseCase(authRepository)

    @Provides
    fun provideLoginUseCase(authRepository: AuthRepository) = LoginUseCase(authRepository)

    @Provides
    fun provideGetUserEmailUseCase(authRepository: AuthRepository) = GetCurrentUserEmailUseCase(authRepository)
}
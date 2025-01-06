package com.example.movieapp.domain.validation.di

import com.example.movieapp.domain.validation.usecase.ValidateTextFieldUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ValidationUseCasesModule {

    @Provides
    fun provideValidateTextFieldUseCase() = ValidateTextFieldUseCase()
}
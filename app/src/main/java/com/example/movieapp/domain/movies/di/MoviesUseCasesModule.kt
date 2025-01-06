package com.example.movieapp.domain.movies.di

import com.example.movieapp.domain.movies.repository.MoviesRepository
import com.example.movieapp.domain.movies.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MoviesUseCasesModule {
    @Provides
    fun provideGetMoviesUseCase(moviesRepository: MoviesRepository) = GetMoviesUseCase(moviesRepository)
}
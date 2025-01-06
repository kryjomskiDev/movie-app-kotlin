package com.example.movieapp.di

import com.example.movieapp.data.auth.repository.AuthRepositoryImpl
import com.example.movieapp.data.movies.repository.MoviesRepositoryImpl
import com.example.movieapp.domain.auth.repository.AuthRepository
import com.example.movieapp.domain.movies.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindMoviesRepository(impl: MoviesRepositoryImpl): MoviesRepository
}
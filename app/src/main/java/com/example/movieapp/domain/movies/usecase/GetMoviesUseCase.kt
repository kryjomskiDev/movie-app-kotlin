package com.example.movieapp.domain.movies.usecase

import androidx.paging.PagingData
import com.example.movieapp.domain.movies.model.Movie
import com.example.movieapp.domain.movies.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke(): Flow<PagingData<Movie>> = moviesRepository.getMovies()
}
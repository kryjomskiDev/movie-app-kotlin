package com.example.movieapp.domain.movies.repository

import androidx.paging.PagingData
import com.example.movieapp.domain.movies.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMovies() : Flow<PagingData<Movie>>
}
package com.example.movieapp.data.movies.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import com.example.movieapp.data.movies.datasource.MoviesApi
import com.example.movieapp.data.movies.datasource.MoviesPagingSource
import com.example.movieapp.domain.movies.model.Movie
import com.example.movieapp.domain.movies.repository.MoviesRepository
import com.example.movieapp.networkingconfig.NetworkingConfig
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi
) : MoviesRepository {

    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = NetworkingConfig.pagingConfig,
            pagingSourceFactory = { MoviesPagingSource(moviesApi) }

        ).flow
    }
}
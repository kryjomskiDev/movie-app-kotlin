package com.example.movieapp.data.movies.datasource

import com.example.movieapp.data.movies.dto.MovieListDto
import com.example.movieapp.networkingconfig.NetworkingConfig.MOVIES_LIST_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET(MOVIES_LIST_ENDPOINT)
    suspend fun getMovies(@Query("page") page: Int): MovieListDto
}
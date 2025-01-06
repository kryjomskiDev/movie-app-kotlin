package com.example.movieapp.data.movies.dto

import com.example.movieapp.domain.movies.model.Movie

data class MovieListDto(val results: List<MovieDto>)

internal fun MovieListDto.toDomain(): List<Movie> = results.map { it.toDomain() }
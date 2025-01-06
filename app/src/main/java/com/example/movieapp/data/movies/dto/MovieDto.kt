package com.example.movieapp.data.movies.dto

import com.example.movieapp.domain.movies.model.Movie
import com.google.gson.annotations.SerializedName


data class MovieDto(
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("poster_path") val posterPath: String,
)

internal fun MovieDto.toDomain(): Movie = Movie(
    id = id,
    title = title,
    overview = overview,
    posterPath = posterPath
)
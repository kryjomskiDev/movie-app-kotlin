package com.example.movieapp.domain.movies.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
)
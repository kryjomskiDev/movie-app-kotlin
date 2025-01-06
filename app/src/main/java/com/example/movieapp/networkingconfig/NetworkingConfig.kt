package com.example.movieapp.networkingconfig

import androidx.paging.PagingConfig

internal object NetworkingConfig {
    const val API_BASE_URL = "https://api.themoviedb.org/"

    const val MOVIES_LIST_ENDPOINT = "3/movie/top_rated"

    private const val PAGE_SIZE = 10

    val pagingConfig = PagingConfig(
        pageSize = PAGE_SIZE
    )

}
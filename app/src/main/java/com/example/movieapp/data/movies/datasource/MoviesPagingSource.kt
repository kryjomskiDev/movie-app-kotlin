package com.example.movieapp.data.movies.datasource


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movieapp.data.movies.dto.toDomain
import com.example.movieapp.domain.movies.model.Movie
import retrofit2.HttpException
import java.io.IOException

class MoviesPagingSource(
    private val moviesApi: MoviesApi
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
       return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val movies = moviesApi.getMovies(currentPage)

            LoadResult.Page(
                data = movies.toDomain(),
                prevKey = if (currentPage == 1) null else currentPage.minus(1),
                nextKey = if (movies.results.isEmpty()) null else currentPage.plus(1)
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}
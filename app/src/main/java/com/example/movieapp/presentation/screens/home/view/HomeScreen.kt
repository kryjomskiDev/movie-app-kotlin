package com.example.movieapp.presentation.screens.home.view

import MovieTile
import android.media.Image
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.R
import com.example.movieapp.domain.movies.model.Movie
import com.example.movieapp.presentation.components.ErrorBody
import com.example.movieapp.presentation.screens.home.viewmodel.HomeScreenViewModel
import com.example.movieapp.style.theme.AppTypography
import com.example.movieapp.style.theme.Dimens

@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<HomeScreenViewModel>()
    val moviesPagingItems = viewModel.moviesState.collectAsLazyPagingItems()

    Box(

        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.m),
    ) {


        when (moviesPagingItems.loadState.refresh) {
            is LoadState.Loading -> {
                CircularProgressIndicator()
            }

            is LoadState.NotLoading -> {
                if (moviesPagingItems.itemCount == 0) {
                    Text(
                        stringResource(R.string.movies_empty_title),
                        style = AppTypography.headlineSmall,
                    )
                } else {
                    LazyColumn {
                        items(moviesPagingItems.itemCount) { index ->
                            MovieTile(
                                movie = moviesPagingItems[index]!!,
                                modifier = Modifier.padding(vertical = Dimens.s)
                            )
                        }
                    }
                }
            }

            else -> {}
        }
    }

}

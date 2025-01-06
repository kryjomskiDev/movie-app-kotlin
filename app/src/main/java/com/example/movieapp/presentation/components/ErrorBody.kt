package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.movieapp.R
import com.example.movieapp.style.theme.AppTypography
import com.example.movieapp.style.theme.Dimens


@Composable
fun ErrorBody(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Icon(
            Icons.Rounded.Warning,
            contentDescription = "",
            Modifier
                .size(Dimens.xxc)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(Dimens.m))
        Text(
            stringResource(R.string.error_bottom_sheet_title),
            style = AppTypography.headlineSmall,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(Dimens.m))
        MovieAppButton(
            title = stringResource(R.string.refresh),
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

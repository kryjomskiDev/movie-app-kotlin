package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movieapp.style.theme.Dimens

@Composable
fun MovieAppButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    isEnabled: Boolean = true
) {
    Button(
        enabled = isEnabled,
        onClick = onClick,
        modifier = modifier,
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onSecondary,
                strokeWidth = Dimens.xxs,
                modifier = Modifier.size(Dimens.ms)
            )
        } else {
            Text(title)
        }
    }
}
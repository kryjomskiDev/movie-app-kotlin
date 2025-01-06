package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movieapp.R
import com.example.movieapp.style.theme.AppTypography
import com.example.movieapp.style.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorBottomSheet(
    title: String,
    description: String,
    onDismiss: () -> Unit,
    sheetState: SheetState,
    modifier: Modifier = Modifier
) {
    ModalBottomSheet(
        onDismissRequest =  onDismiss,
        sheetState = sheetState,
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.padding(Dimens.m)
        ) {
            Text(title, style = AppTypography.headlineSmall)
            Spacer(Modifier.height(Dimens.m))
            Text(description, style = AppTypography.bodyMedium)
            Spacer(Modifier.height(Dimens.xl))
            MovieAppButton(
                title = stringResource(R.string.error_bottom_sheet_button_title),
                onClick = onDismiss,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
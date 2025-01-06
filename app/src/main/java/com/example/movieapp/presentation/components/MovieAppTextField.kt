package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.example.movieapp.style.theme.Dimens

@Composable
fun MovieAppTextField(
    title: String,
    value: String,
    errorText: String?,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            title,
            style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary),
            )
        Spacer(Modifier.height(Dimens.s))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            isError = errorText != null,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.None,
            ),
            visualTransformation = visualTransformation,
        )
        if(errorText != null) {
            Spacer(Modifier.height(Dimens.xs))
            Text(
                errorText,
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.error),
            )
        }
    }
}
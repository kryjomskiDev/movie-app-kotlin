package com.example.movieapp.presentation.components

import MovieAppOutlinedButton
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.example.movieapp.R
import com.example.movieapp.style.theme.Dimens

@Composable
fun AuthForm(
    formTitle: String,
    @DrawableRes imageId: Int,
    emailFieldValue: String,
    onEmailChange: (String) -> Unit,
    passwordFieldValue: String,
    onPasswordValueChange: (String) -> Unit,
    onFilledButtonClick: () -> Unit,
    filledButtonTitle: String,
    onOutlinedButtonClick: () -> Unit,
    outlinedButtonTitle: String,
    modifier: Modifier = Modifier,
    passwordErrorText: String? = null,
    emailErrorText: String? = null,
    isLoading: Boolean = false,
    canProceed: Boolean = false,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            modifier = Modifier.height(height = Dimens.imageSize)
        )
        Spacer(Modifier.height(Dimens.m))
        Text(
            text = formTitle,
            style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.primary),
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.size(Dimens.m))
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(Dimens.m)
            ) {
                MovieAppTextField(
                    title = stringResource(R.string.email),
                    value = emailFieldValue,
                    errorText = emailErrorText,
                    onValueChange = onEmailChange,
                    keyboardType = KeyboardType.Email
                )
                Spacer(Modifier.size(Dimens.m))
                MovieAppTextField(
                    title = stringResource(R.string.password),
                    value = passwordFieldValue,
                    errorText = passwordErrorText,
                    onValueChange =  onPasswordValueChange,
                    keyboardType = KeyboardType.Password,
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(Modifier.size(Dimens.m))
                MovieAppButton(
                    title = filledButtonTitle,
                    onClick = onFilledButtonClick,
                    isLoading = isLoading,
                    isEnabled = canProceed,
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(Modifier.size(Dimens.s))
                MovieAppOutlinedButton(
                    title = outlinedButtonTitle,
                    onClick = onOutlinedButtonClick,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
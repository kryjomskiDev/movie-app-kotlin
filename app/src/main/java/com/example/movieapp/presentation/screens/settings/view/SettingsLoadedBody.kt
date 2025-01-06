package com.example.movieapp.presentation.screens.settings.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.movieapp.R
import com.example.movieapp.style.theme.Dimens


@Composable
fun SettingsLoadedBody(
    email: String,
    onLogoutTap: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            stringResource(R.string.settings_account),
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(Modifier.height(Dimens.s))
        Box(
            modifier = Modifier.clip(RoundedCornerShape(Dimens.s))
        ) {
            ListItem(
                headlineContent = { Text(stringResource(R.string.email)) },
                supportingContent = { Text(email) },
                leadingContent = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = ""
                    )
                },
                colors = ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    headlineColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
            )

        }
        Spacer(Modifier.height(Dimens.m))
        Text(
            stringResource(R.string.settings_general),
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(Modifier.height(Dimens.s))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(Dimens.s))
                .clickable {
                    onLogoutTap()
                }
        ) {
            ListItem(
                headlineContent = { Text(stringResource(R.string.settings_logout)) },
                leadingContent = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                        contentDescription = ""
                    )
                },
                trailingContent = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = ""
                    )

                },
                colors = ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    headlineColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
            )

        }
    }


}

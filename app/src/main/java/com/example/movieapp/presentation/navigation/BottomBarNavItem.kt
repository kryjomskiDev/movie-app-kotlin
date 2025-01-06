package com.example.movieapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarNavItem(
    val route: MovieAppRoutes,
    val icon: ImageVector
) {
    data object Home : BottomBarNavItem(
        route = MovieAppRoutes.HomeScreen,
        icon = Icons.Outlined.Home,
    )

    data object Settings : BottomBarNavItem(
        route = MovieAppRoutes.SettingsScreen,
        icon = Icons.Outlined.Settings
    )

}
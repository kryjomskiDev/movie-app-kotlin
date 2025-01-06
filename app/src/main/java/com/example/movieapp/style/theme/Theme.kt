package com.example.movieapp.presentation.theme
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.movieapp.style.theme.AppTypography
import com.example.movieapp.style.theme.backgroundDark
import com.example.movieapp.style.theme.backgroundDarkHighContrast
import com.example.movieapp.style.theme.backgroundDarkMediumContrast
import com.example.movieapp.style.theme.backgroundLight
import com.example.movieapp.style.theme.backgroundLightHighContrast
import com.example.movieapp.style.theme.backgroundLightMediumContrast
import com.example.movieapp.style.theme.errorContainerDark
import com.example.movieapp.style.theme.errorContainerDarkHighContrast
import com.example.movieapp.style.theme.errorContainerDarkMediumContrast
import com.example.movieapp.style.theme.errorContainerLight
import com.example.movieapp.style.theme.errorContainerLightHighContrast
import com.example.movieapp.style.theme.errorContainerLightMediumContrast
import com.example.movieapp.style.theme.errorDark
import com.example.movieapp.style.theme.errorDarkHighContrast
import com.example.movieapp.style.theme.errorDarkMediumContrast
import com.example.movieapp.style.theme.errorLight
import com.example.movieapp.style.theme.errorLightHighContrast
import com.example.movieapp.style.theme.errorLightMediumContrast
import com.example.movieapp.style.theme.inverseOnSurfaceDark
import com.example.movieapp.style.theme.inverseOnSurfaceDarkHighContrast
import com.example.movieapp.style.theme.inverseOnSurfaceDarkMediumContrast
import com.example.movieapp.style.theme.inverseOnSurfaceLight
import com.example.movieapp.style.theme.inverseOnSurfaceLightHighContrast
import com.example.movieapp.style.theme.inverseOnSurfaceLightMediumContrast
import com.example.movieapp.style.theme.inversePrimaryDark
import com.example.movieapp.style.theme.inversePrimaryDarkHighContrast
import com.example.movieapp.style.theme.inversePrimaryDarkMediumContrast
import com.example.movieapp.style.theme.inversePrimaryLight
import com.example.movieapp.style.theme.inversePrimaryLightHighContrast
import com.example.movieapp.style.theme.inversePrimaryLightMediumContrast
import com.example.movieapp.style.theme.inverseSurfaceDark
import com.example.movieapp.style.theme.inverseSurfaceDarkHighContrast
import com.example.movieapp.style.theme.inverseSurfaceDarkMediumContrast
import com.example.movieapp.style.theme.inverseSurfaceLight
import com.example.movieapp.style.theme.inverseSurfaceLightHighContrast
import com.example.movieapp.style.theme.inverseSurfaceLightMediumContrast
import com.example.movieapp.style.theme.onBackgroundDark
import com.example.movieapp.style.theme.onBackgroundDarkHighContrast
import com.example.movieapp.style.theme.onBackgroundDarkMediumContrast
import com.example.movieapp.style.theme.onBackgroundLight
import com.example.movieapp.style.theme.onBackgroundLightHighContrast
import com.example.movieapp.style.theme.onBackgroundLightMediumContrast
import com.example.movieapp.style.theme.onErrorContainerDark
import com.example.movieapp.style.theme.onErrorContainerDarkHighContrast
import com.example.movieapp.style.theme.onErrorContainerDarkMediumContrast
import com.example.movieapp.style.theme.onErrorContainerLight
import com.example.movieapp.style.theme.onErrorContainerLightHighContrast
import com.example.movieapp.style.theme.onErrorContainerLightMediumContrast
import com.example.movieapp.style.theme.onErrorDark
import com.example.movieapp.style.theme.onErrorDarkHighContrast
import com.example.movieapp.style.theme.onErrorDarkMediumContrast
import com.example.movieapp.style.theme.onErrorLight
import com.example.movieapp.style.theme.onErrorLightHighContrast
import com.example.movieapp.style.theme.onErrorLightMediumContrast
import com.example.movieapp.style.theme.onPrimaryContainerDark
import com.example.movieapp.style.theme.onPrimaryContainerDarkHighContrast
import com.example.movieapp.style.theme.onPrimaryContainerDarkMediumContrast
import com.example.movieapp.style.theme.onPrimaryContainerLight
import com.example.movieapp.style.theme.onPrimaryContainerLightHighContrast
import com.example.movieapp.style.theme.onPrimaryContainerLightMediumContrast
import com.example.movieapp.style.theme.onPrimaryDark
import com.example.movieapp.style.theme.onPrimaryDarkHighContrast
import com.example.movieapp.style.theme.onPrimaryDarkMediumContrast
import com.example.movieapp.style.theme.onPrimaryLight
import com.example.movieapp.style.theme.onPrimaryLightHighContrast
import com.example.movieapp.style.theme.onPrimaryLightMediumContrast
import com.example.movieapp.style.theme.onSecondaryContainerDark
import com.example.movieapp.style.theme.onSecondaryContainerDarkHighContrast
import com.example.movieapp.style.theme.onSecondaryContainerDarkMediumContrast
import com.example.movieapp.style.theme.onSecondaryContainerLight
import com.example.movieapp.style.theme.onSecondaryContainerLightHighContrast
import com.example.movieapp.style.theme.onSecondaryContainerLightMediumContrast
import com.example.movieapp.style.theme.onSecondaryDark
import com.example.movieapp.style.theme.onSecondaryDarkHighContrast
import com.example.movieapp.style.theme.onSecondaryDarkMediumContrast
import com.example.movieapp.style.theme.onSecondaryLight
import com.example.movieapp.style.theme.onSecondaryLightHighContrast
import com.example.movieapp.style.theme.onSecondaryLightMediumContrast
import com.example.movieapp.style.theme.onSurfaceDark
import com.example.movieapp.style.theme.onSurfaceDarkHighContrast
import com.example.movieapp.style.theme.onSurfaceDarkMediumContrast
import com.example.movieapp.style.theme.onSurfaceLight
import com.example.movieapp.style.theme.onSurfaceLightHighContrast
import com.example.movieapp.style.theme.onSurfaceLightMediumContrast
import com.example.movieapp.style.theme.onSurfaceVariantDark
import com.example.movieapp.style.theme.onSurfaceVariantDarkHighContrast
import com.example.movieapp.style.theme.onSurfaceVariantDarkMediumContrast
import com.example.movieapp.style.theme.onSurfaceVariantLight
import com.example.movieapp.style.theme.onSurfaceVariantLightHighContrast
import com.example.movieapp.style.theme.onSurfaceVariantLightMediumContrast
import com.example.movieapp.style.theme.onTertiaryContainerDark
import com.example.movieapp.style.theme.onTertiaryContainerDarkHighContrast
import com.example.movieapp.style.theme.onTertiaryContainerDarkMediumContrast
import com.example.movieapp.style.theme.onTertiaryContainerLight
import com.example.movieapp.style.theme.onTertiaryContainerLightHighContrast
import com.example.movieapp.style.theme.onTertiaryContainerLightMediumContrast
import com.example.movieapp.style.theme.onTertiaryDark
import com.example.movieapp.style.theme.onTertiaryDarkHighContrast
import com.example.movieapp.style.theme.onTertiaryDarkMediumContrast
import com.example.movieapp.style.theme.onTertiaryLight
import com.example.movieapp.style.theme.onTertiaryLightHighContrast
import com.example.movieapp.style.theme.onTertiaryLightMediumContrast
import com.example.movieapp.style.theme.outlineDark
import com.example.movieapp.style.theme.outlineDarkHighContrast
import com.example.movieapp.style.theme.outlineDarkMediumContrast
import com.example.movieapp.style.theme.outlineLight
import com.example.movieapp.style.theme.outlineLightHighContrast
import com.example.movieapp.style.theme.outlineLightMediumContrast
import com.example.movieapp.style.theme.outlineVariantDark
import com.example.movieapp.style.theme.outlineVariantDarkHighContrast
import com.example.movieapp.style.theme.outlineVariantDarkMediumContrast
import com.example.movieapp.style.theme.outlineVariantLight
import com.example.movieapp.style.theme.outlineVariantLightHighContrast
import com.example.movieapp.style.theme.outlineVariantLightMediumContrast
import com.example.movieapp.style.theme.primaryContainerDark
import com.example.movieapp.style.theme.primaryContainerDarkHighContrast
import com.example.movieapp.style.theme.primaryContainerDarkMediumContrast
import com.example.movieapp.style.theme.primaryContainerLight
import com.example.movieapp.style.theme.primaryContainerLightHighContrast
import com.example.movieapp.style.theme.primaryContainerLightMediumContrast
import com.example.movieapp.style.theme.primaryDark
import com.example.movieapp.style.theme.primaryDarkHighContrast
import com.example.movieapp.style.theme.primaryDarkMediumContrast
import com.example.movieapp.style.theme.primaryLight
import com.example.movieapp.style.theme.primaryLightHighContrast
import com.example.movieapp.style.theme.primaryLightMediumContrast
import com.example.movieapp.style.theme.scrimDark
import com.example.movieapp.style.theme.scrimDarkHighContrast
import com.example.movieapp.style.theme.scrimDarkMediumContrast
import com.example.movieapp.style.theme.scrimLight
import com.example.movieapp.style.theme.scrimLightHighContrast
import com.example.movieapp.style.theme.scrimLightMediumContrast
import com.example.movieapp.style.theme.secondaryContainerDark
import com.example.movieapp.style.theme.secondaryContainerDarkHighContrast
import com.example.movieapp.style.theme.secondaryContainerDarkMediumContrast
import com.example.movieapp.style.theme.secondaryContainerLight
import com.example.movieapp.style.theme.secondaryContainerLightHighContrast
import com.example.movieapp.style.theme.secondaryContainerLightMediumContrast
import com.example.movieapp.style.theme.secondaryDark
import com.example.movieapp.style.theme.secondaryDarkHighContrast
import com.example.movieapp.style.theme.secondaryDarkMediumContrast
import com.example.movieapp.style.theme.secondaryLight
import com.example.movieapp.style.theme.secondaryLightHighContrast
import com.example.movieapp.style.theme.secondaryLightMediumContrast
import com.example.movieapp.style.theme.surfaceBrightDark
import com.example.movieapp.style.theme.surfaceBrightDarkHighContrast
import com.example.movieapp.style.theme.surfaceBrightDarkMediumContrast
import com.example.movieapp.style.theme.surfaceBrightLight
import com.example.movieapp.style.theme.surfaceBrightLightHighContrast
import com.example.movieapp.style.theme.surfaceBrightLightMediumContrast
import com.example.movieapp.style.theme.surfaceContainerDark
import com.example.movieapp.style.theme.surfaceContainerDarkHighContrast
import com.example.movieapp.style.theme.surfaceContainerDarkMediumContrast
import com.example.movieapp.style.theme.surfaceContainerHighDark
import com.example.movieapp.style.theme.surfaceContainerHighDarkHighContrast
import com.example.movieapp.style.theme.surfaceContainerHighDarkMediumContrast
import com.example.movieapp.style.theme.surfaceContainerHighLight
import com.example.movieapp.style.theme.surfaceContainerHighLightHighContrast
import com.example.movieapp.style.theme.surfaceContainerHighLightMediumContrast
import com.example.movieapp.style.theme.surfaceContainerHighestDark
import com.example.movieapp.style.theme.surfaceContainerHighestDarkHighContrast
import com.example.movieapp.style.theme.surfaceContainerHighestDarkMediumContrast
import com.example.movieapp.style.theme.surfaceContainerHighestLight
import com.example.movieapp.style.theme.surfaceContainerHighestLightHighContrast
import com.example.movieapp.style.theme.surfaceContainerHighestLightMediumContrast
import com.example.movieapp.style.theme.surfaceContainerLight
import com.example.movieapp.style.theme.surfaceContainerLightHighContrast
import com.example.movieapp.style.theme.surfaceContainerLightMediumContrast
import com.example.movieapp.style.theme.surfaceContainerLowDark
import com.example.movieapp.style.theme.surfaceContainerLowDarkHighContrast
import com.example.movieapp.style.theme.surfaceContainerLowDarkMediumContrast
import com.example.movieapp.style.theme.surfaceContainerLowLight
import com.example.movieapp.style.theme.surfaceContainerLowLightHighContrast
import com.example.movieapp.style.theme.surfaceContainerLowLightMediumContrast
import com.example.movieapp.style.theme.surfaceContainerLowestDark
import com.example.movieapp.style.theme.surfaceContainerLowestDarkHighContrast
import com.example.movieapp.style.theme.surfaceContainerLowestDarkMediumContrast
import com.example.movieapp.style.theme.surfaceContainerLowestLight
import com.example.movieapp.style.theme.surfaceContainerLowestLightHighContrast
import com.example.movieapp.style.theme.surfaceContainerLowestLightMediumContrast
import com.example.movieapp.style.theme.surfaceDark
import com.example.movieapp.style.theme.surfaceDarkHighContrast
import com.example.movieapp.style.theme.surfaceDarkMediumContrast
import com.example.movieapp.style.theme.surfaceDimDark
import com.example.movieapp.style.theme.surfaceDimDarkHighContrast
import com.example.movieapp.style.theme.surfaceDimDarkMediumContrast
import com.example.movieapp.style.theme.surfaceDimLight
import com.example.movieapp.style.theme.surfaceDimLightHighContrast
import com.example.movieapp.style.theme.surfaceDimLightMediumContrast
import com.example.movieapp.style.theme.surfaceLight
import com.example.movieapp.style.theme.surfaceLightHighContrast
import com.example.movieapp.style.theme.surfaceLightMediumContrast
import com.example.movieapp.style.theme.surfaceVariantDark
import com.example.movieapp.style.theme.surfaceVariantDarkHighContrast
import com.example.movieapp.style.theme.surfaceVariantDarkMediumContrast
import com.example.movieapp.style.theme.surfaceVariantLight
import com.example.movieapp.style.theme.surfaceVariantLightHighContrast
import com.example.movieapp.style.theme.surfaceVariantLightMediumContrast
import com.example.movieapp.style.theme.tertiaryContainerDark
import com.example.movieapp.style.theme.tertiaryContainerDarkHighContrast
import com.example.movieapp.style.theme.tertiaryContainerDarkMediumContrast
import com.example.movieapp.style.theme.tertiaryContainerLight
import com.example.movieapp.style.theme.tertiaryContainerLightHighContrast
import com.example.movieapp.style.theme.tertiaryContainerLightMediumContrast
import com.example.movieapp.style.theme.tertiaryDark
import com.example.movieapp.style.theme.tertiaryDarkHighContrast
import com.example.movieapp.style.theme.tertiaryDarkMediumContrast
import com.example.movieapp.style.theme.tertiaryLight
import com.example.movieapp.style.theme.tertiaryLightHighContrast
import com.example.movieapp.style.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}


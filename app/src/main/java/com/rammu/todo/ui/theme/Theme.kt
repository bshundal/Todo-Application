package com.rammu.todo.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    // Primary: Your main brand color, often orange
    primary = Orange500,
    onPrimary = White, // Text/icons on primary color

    // Primary Container: For less prominent elements that still use primary branding
    primaryContainer = Orange300,
    onPrimaryContainer = Black800,

    // Secondary: Can be a complementary color (e.g., Teal) or a different shade of orange
    secondary = Teal700, // Or Orange700 if you prefer a monochrome orange theme
    onSecondary = White,

    // Secondary Container:
    secondaryContainer = Teal200,
    onSecondaryContainer = Black800,

    // Tertiary: A third distinct color, if needed
    tertiary = Orange700,
    onTertiary = White,

    // Background: Main screen background
    background = LightGray100, // Very light gray for light mode background
    onBackground = Black800, // Text/icons on background

    // Surface: Cards, sheets, dialogs, buttons
    surface = White, // Clean white for surfaces in light mode
    onSurface = Black800, // Text/icons on surface
    surfaceVariant = LightGray300, // Less prominent surface color
    onSurfaceVariant = Black900, // Text/icons on surface variant

    // Error: For validation errors, warnings
    error = RedErrorLight,
    onError = White,
    errorContainer = RedErrorLight.copy(alpha = 0.1f), // A subtle error background
    onErrorContainer = RedErrorLight,

    // Outline: For OutlinedTextField borders etc.
    outline = DarkGray500
)

// --- Dark Theme Colors ---
private val DarkColorScheme = darkColorScheme(
    primary = Orange500,
    onPrimary = Black900, // Black text/icons on primary (orange)

    primaryContainer = Orange700,
    onPrimaryContainer = White,

    secondary = Teal200, // Lighter Teal for dark theme
    onSecondary = Black900,

    secondaryContainer = Teal700,
    onSecondaryContainer = White,

    tertiary = Orange300,
    onTertiary = Black900,

    background = Black800, // Deep black/dark gray for background
    onBackground = White, // White text/icons on background

    surface = DarkGray700, // Dark gray for surfaces in dark mode
    onSurface = White, // White text/icons on surface
    surfaceVariant = DarkGray500,
    onSurfaceVariant = White,

    error = RedErrorDark,
    onError = Black900,
    errorContainer = RedErrorDark.copy(alpha = 0.3f), // Slightly more visible error background
    onErrorContainer = White,

    outline = LightGray300
)

@Composable
fun TodoAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true, // Set to false if you want strict brand colors
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Set system bar colors to match your app's theme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            window.navigationBarColor = colorScheme.surface.toArgb() // Often surface for nav bar
            // Ensure status bar icons are visible based on background luminance
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars =
                !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Assuming you have a Typography defined in Type.kt
        content = content
    )
}
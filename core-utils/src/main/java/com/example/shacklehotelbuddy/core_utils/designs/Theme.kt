package com.example.shacklehotelbuddy.core_utils.designs

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColorScheme(
    primary = Color.White,
    primaryContainer = Primary,
    secondary = Ascent,
    background = Color.Black,
    surface = Color.White,
    onSurface = Color.White,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColorScheme(
    primary = DarkPrimary,
    primaryContainer = Color(0xFFedf6f9),
    secondary = Ascent,
    background = Color.White,
    surface = Color.Black,
    onSurface = DarkPrimary
)

@Composable
fun ShackleHotelBuddyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors, typography = typography, shapes = Shapes, content = content
    )
}

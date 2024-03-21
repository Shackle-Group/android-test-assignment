package com.example.shacklehotelbuddy.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.shacklehotelbuddy.R

val ShackleFontFamily = FontFamily(
    Font(R.font.circular_std_black, FontWeight.Black),
    Font(R.font.circular_std_bold, FontWeight.Bold),
    Font(R.font.circular_std_medium, FontWeight.Medium),
)


@Immutable
data class CustomTypography constructor(
    val titleBig: TextStyle = TextStyle(
        fontFamily = ShackleFontFamily,
        fontWeight = FontWeight.W100,
        fontSize = 48.sp,
        letterSpacing = 1.sp
    ),
    val bodyLarge: TextStyle = TextStyle(
        fontFamily = ShackleFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.5.sp
    ),
    val bodyMedium: TextStyle = TextStyle(
        fontFamily = ShackleFontFamily,
        fontWeight = FontWeight.W100,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
    val button: TextStyle = TextStyle(
        fontFamily = ShackleFontFamily,
        fontWeight = FontWeight.W100,
        fontSize = 18.sp,
        lineHeight = 20.sp,
        letterSpacing = 1.sp,
    ),
)

val LocalTypography = staticCompositionLocalOf {
    CustomTypography()
}
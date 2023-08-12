package com.adrianczuczka.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class CustomTypography constructor(
    val title: TextStyle = TextStyle(
        fontSize = 44.sp,
        lineHeight = 48.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight(450),
    ),
    val bodyMedium: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
)

val LocalTypography = staticCompositionLocalOf {
    CustomTypography()
}
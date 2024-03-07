package com.example.shacklehotelbuddy.ui.components

import androidx.compose.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@androidx.compose.runtime.Composable
@Composable
fun CustomText(
    text: String,
    fontSize: Int,
    fontWeight: FontWeight,
    color: Color,
    modifier: Modifier,
    textAlign: TextAlign
) {
    Text(
        textAlign = textAlign,
        modifier = modifier,
        color = color,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        text = text
    )
}


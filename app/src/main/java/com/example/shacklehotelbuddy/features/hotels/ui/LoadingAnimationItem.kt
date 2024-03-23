package com.example.shacklehotelbuddy.features.hotels.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.shacklehotelbuddy.ui.theme.GrayBorder
import com.valentinilk.shimmer.shimmer

/**
 * Loading animation item.
 */
@Composable
fun LoadingAnimationItem() {
    Box(
        modifier = Modifier.shimmer(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 12.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .border(BorderStroke(1.dp, GrayBorder), RoundedCornerShape(16.dp))
                .background(GrayBorder),
        )
    }
}
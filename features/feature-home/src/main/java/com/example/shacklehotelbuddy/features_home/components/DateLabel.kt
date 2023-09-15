package com.example.shacklehotelbuddy.features_home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shacklehotelbuddy.core_resources.R

@Composable
fun DateLabel(
    label: String,
    icon: Int,
    modifier: Modifier = Modifier,
) {
    Row(modifier) {
        Icon(
            modifier = Modifier
                .width(20.dp)
                .height(20.dp),
            painter = painterResource(icon),
            contentDescription = "",
        )
        Text(
            text = label, modifier = Modifier.padding(start = 8.dp), style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Font(R.font.circularstd_medium)),
                fontWeight = FontWeight(450),
                color = Color(0xFF6D6D6D),
            )
        )
    }
}
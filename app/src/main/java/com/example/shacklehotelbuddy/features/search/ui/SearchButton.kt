package com.example.shacklehotelbuddy.features.search.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme

@Composable
fun SearchButton(searchAction: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = ShackleHotelBuddyTheme.colors.teal),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        onClick = { searchAction() }
    ) {
        Text(
            text = stringResource(id = R.string.search_search),
            style = ShackleHotelBuddyTheme.typography.button,
        )
    }
}
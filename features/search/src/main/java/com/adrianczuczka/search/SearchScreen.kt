package com.adrianczuczka.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun SearchScreen() {
    Column {
        LazyColumn {
            item {
                Text(text = stringResource(id = R.string.search_screen_title_text))
            }
            item {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_event_upcoming),
                        contentDescription = null
                    )
                    Text(text = stringResource(id = R.string.search_screen_check_in_date_text))
                }
            }
        }
    }
}
package com.example.shacklehotelbuddy.features_home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shacklehotelbuddy.core_database.entities.SearchQueryEntity
import com.example.shacklehotelbuddy.features_home.presentation.RecentSearchesList
import com.example.shacklehotelbuddy.core_resources.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecentSearchQueryItem(
    modifier: Modifier = Modifier,
    searchQuery: SearchQueryEntity,
    onSearchQuerySelected: (SearchQueryEntity) -> Unit
) {
    Card(modifier = modifier.fillMaxWidth(), onClick = { onSearchQuerySelected(searchQuery) }) {
        Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)) {
            Icon(
                painter = painterResource(R.drawable.manage_history),
                contentDescription = "",
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = "${
                    com.example.shacklehotelbuddy.core_utils.utils.TimeUtils.simpleFormat(
                        searchQuery.checkInDate
                    )
                } - ${
                    com.example.shacklehotelbuddy.core_utils.utils.TimeUtils.simpleFormat(
                        searchQuery.checkoutDate
                    )
                }", modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            )
            Text(
                text =
                "${searchQuery.adultsCount} adult, ${searchQuery.childrenCount} children",
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun SearchQueryItemPreview() {
    RecentSearchesList(arrayListOf()) {}
}


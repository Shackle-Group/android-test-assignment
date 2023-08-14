package com.adrianczuczka.features.properties

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.adrianczuczka.features.properties.viewmodel.PropertiesViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PropertiesScreen(
    viewModel: PropertiesViewModel = hiltViewModel(),
) {
    val properties = viewModel.properties.collectAsLazyPagingItems()

    Box {
        if (properties.loadState.refresh is LoadState.Error) {
            Text(
                text = stringResource(id = R.string.properties_error_text),
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
        val isRefreshing = properties.loadState.refresh is LoadState.Loading
        val pullRefreshState = rememberPullRefreshState(
            isRefreshing,
            { properties.refresh() }
        )

        Column {
            Box(
                modifier = Modifier
                    .pullRefresh(pullRefreshState)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(
                        count = properties.itemCount,
                        key = properties.itemKey { property -> property.id }
                    ) { index ->
                        val property = properties[index]
                        if (property != null) {
                            Text(text = property.title)
                        }
                    }
                }

                PullRefreshIndicator(
                    isRefreshing,
                    pullRefreshState,
                    Modifier.align(Alignment.TopCenter)
                )
            }
        }
    }
}
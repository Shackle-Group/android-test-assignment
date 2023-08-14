package com.adrianczuczka.features.properties

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.adrianczuczka.features.properties.content.PropertyRow
import com.adrianczuczka.features.properties.viewmodel.PropertiesViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PropertiesScreen(
    viewModel: PropertiesViewModel = hiltViewModel(),
    navController: NavController,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.top_app_bar_title_text))
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            stringResource(id = R.string.top_app_bar_navigation_icon_content_description)
                        )
                    }
                }
            )
        }
    ) {
        val properties = viewModel.properties.collectAsLazyPagingItems()
        Box(modifier = Modifier.padding(it)) {
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

            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
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
                        ) { index ->
                            val propertyListItem = properties[index]
                            if (propertyListItem != null) {
                                PropertyRow(propertyListItem = propertyListItem)
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
}
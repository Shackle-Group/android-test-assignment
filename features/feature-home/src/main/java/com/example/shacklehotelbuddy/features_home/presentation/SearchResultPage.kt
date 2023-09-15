package com.example.shacklehotelbuddy.features_home.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shacklehotelbuddy.features_home.R as homeR
import com.example.shacklehotelbuddy.core_resources.R
import com.example.shacklehotelbuddy.features_home.components.PropertyDetailsCard
import com.example.shacklehotelbuddy.features_home.data.dto.Property
import com.example.shacklehotelbuddy.features_home.data.mappers.toSearchRequestDto
import kotlinx.coroutines.launch

@Composable
fun SearchResultPage(
    propertyVm: PropertyVm,
    navController: NavController,
) {

    val scope = rememberCoroutineScope()

    val uiResultState by propertyVm.uiResultState.collectAsState()

    LaunchedEffect(Unit) {
        scope.launch {
            propertyVm.fetchProperties()

            Log.d(
                "SearchPage",
                "propertyVm.toSearchRequestDto  ${propertyVm.searchQueryEntity?.toSearchRequestDto()}"
            )
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 48.dp)
    ) {
        Column {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        painter = painterResource(R.drawable.arrow_back),
                        contentDescription = null
                    )
                }
                Text(
                    text = stringResource(R.string.search_results),
                    fontSize = 18.sp,
                    lineHeight = 20.sp,
                    color = Color(0xFF000000),
                    modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
                )
            }

            if (uiResultState.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                    )
                }
            }

            if (uiResultState.errorMessage != null && uiResultState.properties.isNullOrEmpty()) Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = uiResultState.errorMessage ?: "")
            }

            if (!uiResultState.properties.isNullOrEmpty()) {
                SearchResultsList(uiResultState.properties!!)
            }

        }
    }
}

@Composable
fun SearchResultsList(properties: List<Property?>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(items = properties, itemContent = { item ->
            item?.let { PropertyDetailsCard(it) }
        })
    }
}


@Preview
@Composable
fun SearchResultPagePreview() {
    SearchResultPage(
        propertyVm = hiltViewModel(),
        navController = rememberNavController(),
    )
}
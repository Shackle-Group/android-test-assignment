package com.example.shacklehotelbuddy.features_splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shacklehotelbuddy.core_utils.designs.Ascent
import com.example.shacklehotelbuddy.core_utils.designs.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.core_utils.navigation.Routes
import com.example.shacklehotelbuddy.core_utils.navigation.UiEvent
import kotlinx.coroutines.delay

@Composable
fun SplashPage(
    modifier: Modifier = Modifier,
    onNavigate: (UiEvent) -> Unit
) {

    LaunchedEffect(Unit){
        delay(1000)
        //onNavigate.invoke(UiEvent.OnNavigate(Routes.searchPage))
    }


    ShackleHotelBuddyTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {

            Image(
                painter = painterResource(id = com.example.shacklehotelbuddy.core_resources.R.drawable.shackle),
                contentDescription = "logo",
                modifier = Modifier
                    .height(170.dp)
                    .width(170.dp)
                    .padding(16.dp)
            )
            Text(
                text = stringResource(id = com.example.shacklehotelbuddy.core_resources.R.string.app_name),
                style = MaterialTheme.typography.headlineMedium.copy(color = Ascent)
            )
        }
    }
}


@Preview
@Composable
fun SplashPagePreview() {
    SplashPage(onNavigate = {

    })
}
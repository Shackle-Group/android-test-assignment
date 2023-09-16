package com.example.shacklehotelbuddy.features_home.presentation

import android.app.DatePickerDialog
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shacklehotelbuddy.core_database.entities.SearchQueryEntity
import com.example.shacklehotelbuddy.core_utils.utils.TimeUtils
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date
import com.example.shacklehotelbuddy.core_resources.R
import com.example.shacklehotelbuddy.core_utils.designs.Ascent
import com.example.shacklehotelbuddy.core_utils.navigation.Routes
import com.example.shacklehotelbuddy.core_utils.navigation.UiEvent
import com.example.shacklehotelbuddy.features_home.components.DateLabel
import com.example.shacklehotelbuddy.features_home.components.RecentSearchQueryItem
import com.example.shacklehotelbuddy.features_home.data.mappers.toSearchRequestDto

@Composable
fun SearchPage(
    propertyVm: PropertyVm = hiltViewModel(),
    onNavigate: (UiEvent) -> Unit
) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            propertyVm.fetchRecentSearch()
        }
    }

    val uiState by propertyVm.uiState.collectAsState()

    SearchContent(
        uiState = uiState,
        onSearchButtonClicked = {
            propertyVm.addSearchQuery(propertyVm.getQuery())
            onNavigate.invoke(UiEvent.OnNavigate(Routes.searchResultsPage))
            Log.d("SearchPage", "propertyVm.searchQueryEntity  ${propertyVm.searchQueryEntity}")
            Log.d(
                "SearchPage",
                "propertyVm.toSearchRequestDto  ${propertyVm.searchQueryEntity?.toSearchRequestDto()}"
            )
        },
        onCheckInDateUpdated = { date -> propertyVm.updateCheckInDate(date) },
        onCheckoutDateUpdated = { date -> propertyVm.updateCheckoutDate(date) },
        onAdultsCountUpdated = { adultsCount -> propertyVm.updateAdultsCount(adultsCount) },
        onChildrenCountUpdated = { childrenCount -> propertyVm.updateChildrenCount(childrenCount) },
        onSearchQuerySelected = { query ->
            propertyVm.searchQueryEntity = query
            onNavigate.invoke(UiEvent.OnNavigate(Routes.searchResultsPage))
        })
}


@Composable
fun SearchContent(
    uiState: SearchPageState,
    onSearchButtonClicked: () -> Unit,
    onCheckInDateUpdated: (Date) -> Unit,
    onCheckoutDateUpdated: (Date) -> Unit,
    onAdultsCountUpdated: (Int) -> Unit,
    onChildrenCountUpdated: (Int) -> Unit,
    onSearchQuerySelected: (SearchQueryEntity) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background), contentScale = ContentScale.FillWidth
            ),
    ) {
        Column {
            Text(
                text = "Select guests, date and time", style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.circularstd_medium)),
                    fontSize = 44.sp,
                    lineHeight = 48.4.sp,
                    color = Color(0xFFFFFFFF),
                ), modifier = Modifier.padding(top = 110.dp, start = 16.dp, end = 16.dp)
            )
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)

            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                            .drawBehind {
                                val borderSize = 1.dp.toPx()
                                val y = size.height - borderSize / 2
                                drawLine(
                                    color = Color.LightGray,
                                    start = Offset(0f, y),
                                    end = Offset(size.width, y),
                                    strokeWidth = borderSize
                                )
                            }, horizontalArrangement = Arrangement.Absolute.SpaceEvenly
                    ) {
                        DateLabel(
                            label = stringResource(id = R.string.check_in_date),
                            icon = R.drawable.event_upcoming,
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(.5f),
                        )
                        Divider(
                            Modifier
                                .width(1.dp)
                                .fillMaxHeight(), color = Color.LightGray
                        )
                        DatePickButton(
                            selectedDate = uiState.checkInDate,
                            onDateSelected = {
                                onCheckInDateUpdated(it)
                            },
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(.5f),
                        )
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                            .drawBehind {
                                val borderSize = 1.dp.toPx()
                                val y = size.height - borderSize / 2
                                drawLine(
                                    color = Color.LightGray,
                                    start = Offset(0f, y),
                                    end = Offset(size.width, y),
                                    strokeWidth = borderSize
                                )
                            },
                    ) {
                        DateLabel(
                            label = stringResource(R.string.check_out_date),
                            icon = R.drawable.event_available,
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(.5f),
                        )
                        Divider(
                            Modifier
                                .width(1.dp)
                                .fillMaxHeight(), color = Color.LightGray
                        )
                        DatePickButton(
                            selectedDate = uiState.checkInDate,
                            onDateSelected = {
                                onCheckoutDateUpdated(it)
                            },
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(.5f),
                        )
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                            .drawBehind {
                                val borderSize = 2.dp.toPx()
                                val y = size.height - borderSize / 2
                                drawLine(
                                    color = Color.LightGray,
                                    start = Offset(0f, y),
                                    end = Offset(size.width, y),
                                    strokeWidth = borderSize
                                )
                            },
                    ) {
                        DateLabel(
                            label = stringResource(R.string.adults), icon = R.drawable.person,
                            modifier = Modifier
                                .weight(.5f)
                                .padding(start = 16.dp)
                                .align(Alignment.CenterVertically),
                        )
                        Divider(
                            Modifier
                                .width(1.dp)
                                .fillMaxHeight(), color = Color.LightGray
                        )
                        InputField(
                            uiState.adultsCount,
                            onCountChange = { onAdultsCountUpdated(it) },
                            Modifier.weight(.5f)
                        )
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                    ) {
                        DateLabel(
                            label = stringResource(R.string.children),
                            icon = R.drawable.supervisor_account,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp)
                                .align(Alignment.CenterVertically),
                        )
                        Divider(
                            Modifier
                                .width(1.dp)
                                .fillMaxHeight(), color = Color.LightGray
                        )
                        InputField(
                            uiState.childrenCount,
                            onCountChange = { onChildrenCountUpdated(it) },
                            Modifier.weight(1f)
                        )
                    }

                }

            }
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = stringResource(R.string.recent_searches),
                style = TextStyle(
                    fontSize = 22.sp,
                    lineHeight = 48.4.sp,
                    color = Color(0xFFFFFFFF),
                )
            )
            RecentSearchesList(uiState.searchQueries, onSearchQuerySelected)
            Button(
                onClick = {
                    onSearchButtonClicked()
                },
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(start = 36.dp, top = 19.dp, end = 36.dp, bottom = 19.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Ascent),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = stringResource(R.string.search), style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 21.6.sp,
                        fontFamily = FontFamily(Font(R.font.circularstd_medium)),
                        fontWeight = FontWeight(450),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.54.sp,
                    )
                )
            }
        }
    }

}

@Composable
fun RecentSearchesList(
    searchHistory: List<SearchQueryEntity>, onSearchQuerySelected: (SearchQueryEntity) -> Unit
) {
    LazyColumn(
        modifier = Modifier.height(180.dp),
        verticalArrangement = Arrangement.spacedBy(-16.dp),
    ) {
        items(items = searchHistory, itemContent = { item ->
            RecentSearchQueryItem(
                modifier = Modifier.padding(16.dp), searchQuery = item, onSearchQuerySelected
            )
        })
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    initialValue: Int, onCountChange: (Int) -> Unit, modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier,
        value = initialValue.toString(),
        maxLines = 1,
        onValueChange = { onCountChange(it.toIntOrNull() ?: 0) },
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        textStyle = TextStyle(
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(Font(R.font.circularstd_medium)),
            fontWeight = FontWeight(450),
            color = Color(0xFF6D6D6D),
        )
    )
}


@Composable
fun DatePickButton(
    selectedDate: Date,
    onDateSelected: (Date) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar[Calendar.YEAR]
    val month = calendar[Calendar.MONTH]
    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
    val datePicker = DatePickerDialog(
        context, { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            val myCalendar = Calendar.getInstance()
            myCalendar.set(Calendar.YEAR, selectedYear)
            myCalendar.set(Calendar.MONTH, selectedMonth)
            myCalendar.set(Calendar.DAY_OF_MONTH, selectedDayOfMonth)
            val newSelectedDate: Date = myCalendar.time
            onDateSelected(newSelectedDate)
        }, year, month, dayOfMonth
    )
    datePicker.datePicker.minDate = calendar.timeInMillis
    var enabled by remember { mutableStateOf(true) }
    ClickableText(modifier = modifier,
        text = AnnotatedString(TimeUtils.simpleFormat(selectedDate)),
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(Font(R.font.circularstd_medium)),
            fontWeight = FontWeight(450),
            color = Color(0xFF6D6D6D),
        ),
        onClick = {
            if (enabled) {
                enabled = false
            }
            datePicker.show()
        })
}

@Preview
@Composable
fun SearchContentPreview() {
    val uiState = SearchPageState(searchQueries = arrayListOf())
    SearchContent(uiState = uiState,
        onSearchButtonClicked = {},
        onCheckInDateUpdated = {},
        onCheckoutDateUpdated = {},
        onAdultsCountUpdated = {},
        onChildrenCountUpdated = {}) {}
}
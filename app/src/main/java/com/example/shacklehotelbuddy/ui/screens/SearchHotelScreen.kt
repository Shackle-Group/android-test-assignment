package com.example.shacklehotelbuddy.ui.screens

import ShackleHotelBuddy.R
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shacklehotelbuddy.PreferenceManager
import com.example.shacklehotelbuddy.ui.components.CustomText
import com.example.shacklehotelbuddy.ui.theme.GrayText
import com.example.shacklehotelbuddy.ui.theme.Teal
import com.example.shacklehotelbuddy.ui.view_model.HotelViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun SearchHotelScreen(navController: NavController, viewModel: HotelViewModel) {

    var isCheckInDatePickerVisible by remember { mutableStateOf(false) }
    var isCheckOutDatePickerVisible by remember { mutableStateOf(false) }
    val checkInDate = remember { mutableStateOf("dd/MM/yyyy") }
    val checkOutDate = remember { mutableStateOf("dd/MM/yyyy") }
    var adults = remember { mutableStateOf(TextFieldValue()) }
    var children = remember { mutableStateOf(TextFieldValue()) }

    val msg = navController.currentBackStackEntry?.savedStateHandle?.get<String>("msg")
    val context = LocalContext.current
    val preferencesManager = remember { PreferenceManager(context) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            Column(
                modifier = Modifier.padding(top = 150.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp),
                    fontSize = 40.sp,
                    color = Color.White,
                    lineHeight = 50.sp,
                    text = stringResource(R.string.select_guests_date_and_time)
                )
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    shape = RoundedCornerShape(corner = CornerSize(20.dp))
                ) {
                    Column {
                        RowDatePickers(
                            stringResource(R.string.check_in_data),
                            R.drawable.event_upcoming,
                            checkInDate.value,
                            datePicker = {isCheckInDatePickerVisible = it}
                        )

                        RowDatePickers(
                            stringResource(R.string.check_out_data),
                            R.drawable.event_available,
                            checkOutDate.value,
                            datePicker = {isCheckOutDatePickerVisible = it}
                        )

                        RowTextFields(
                            stringResource(R.string.adults),
                            R.drawable.person,
                            adults.value,
                            onValueChange = {adults.value = it}
                        )

                        RowTextFields(
                            stringResource(R.string.children),
                            R.drawable.supervisor_account,
                            children.value,
                            onValueChange = {children.value = it}
                        )

                    }
                }
                CustomText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp, start = 20.dp, bottom = 10.dp),
                    fontSize = 20,
                    color = Color.White,
                    text = stringResource(R.string.recent_searches),
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 16.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .drawBehind {
                        val borderSize = 1.dp.toPx()
                        drawLine(
                            color = Color.LightGray,
                            start = Offset(size.width / 9, 0f),
                            end = Offset(size.width / 9, size.height),
                            strokeWidth = borderSize
                        )
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.padding(start = 10.dp),
                        painter = painterResource(id = R.drawable.manage_history),
                        contentDescription = "recent search"
                    )
                    CustomText(
                        text = preferencesManager.getData("checkInDate", "") + " - " + preferencesManager.getData("checkOutDate", "")
                                + "    " + preferencesManager.getData("adults", "") + " " + stringResource(R.string.adult_s)
                                + " " + preferencesManager.getData("children", "") + " " + stringResource(R.string.children),
                        fontSize = 14,
                        fontWeight = FontWeight.Normal,
                        color = GrayText,
                        modifier = Modifier.padding(start = 25.dp),
                        textAlign = TextAlign.Center
                    )
                }

            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
            ) {
                ButtonSearch(
                    checkInDate.value,
                    checkOutDate.value,
                    adults.value.text,
                    children.value.text,
                    navController,
                    viewModel,
                    preferencesManager
                )
            }
            msg?.let {
                Text(it)
            }

            if (isCheckInDatePickerVisible) {
                DatePickerSearchHotel { onDateSelected ->
                    viewModel.checkIntDate(onDateSelected)
                    checkInDate.value = onDateSelected
                    isCheckInDatePickerVisible = false
                }
            }

            if (isCheckOutDatePickerVisible) {
                DatePickerSearchHotel { onDateSelected ->
                    viewModel.checkOutDate(onDateSelected)
                    checkOutDate.value = onDateSelected
                    isCheckOutDatePickerVisible = false
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerSearchHotel(
    onDateSelected: (String) -> Unit
) {
    val state = rememberDatePickerState()
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        DatePickerDialog(modifier = Modifier.scale(.75f), onDismissRequest = {
            openDialog.value = false
        }, confirmButton = {
            TextButton(onClick = {
                onDateSelected(convertMillisToDate(state.selectedDateMillis!!))
                openDialog.value = false
            }) {
                Text(stringResource(R.string.ok))
            }
        }, dismissButton = {
            TextButton(onClick = {
                openDialog.value = false
            }) {
                Text(stringResource(R.string.cancel))
            }
        }, colors = DatePickerDefaults.colors()
        ) {
            DatePicker(
                state = state
            )
        }
    }
}

@Composable
fun RowDatePickers(
    heading: String,
    image: Int,
    date: String,
    datePicker: (Boolean) -> Unit
) {
    var isDatePickerVisible by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier.fillMaxWidth().height(60.dp).padding(horizontal = 16.dp)
            .drawBehind {
                val borderSize = 1.dp.toPx()
                drawLine(
                    color = Color.LightGray,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = borderSize
                )
                drawLine(
                    color = Color.LightGray,
                    start = Offset(size.width / 2, 0f),
                    end = Offset(size.width / 2, size.height),
                    strokeWidth = borderSize
                )
            },
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "check in"
        )
        Text(
            text = heading,
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f).padding(start = 10.dp)
        )
        Text(
            text = date,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f).clickable {
                datePicker(isDatePickerVisible)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RowTextFields(heading: String, image: Int, adults: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            .drawBehind {
                val borderSize = 1.dp.toPx()
                drawLine(
                    color = Color.LightGray,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = borderSize
                )
                drawLine(
                    color = Color.LightGray,
                    start = Offset(size.width / 2, 0f),
                    end = Offset(size.width / 2, size.height),
                    strokeWidth = borderSize
                )
            },
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "adults"
        )
        Text(
            text = heading,
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f).padding(start = 10.dp)
        )
        TextField(
            modifier = Modifier.weight(1f).padding(bottom = 1.dp),
            value = adults,
            onValueChange = onValueChange,
            placeholder = { Text(text = "0") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                cursorColor = Color.White,
                disabledLabelColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White
            ),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Decimal,
            ),
        )
    }
}

@Composable
fun ButtonSearch(
    checkInDate: String,
    checkOutDate: String,
    adults: String,
    children: String,
    navController: NavController,
    viewModel: HotelViewModel,
    preferencesManager: PreferenceManager
) {
    val context = LocalContext.current

    Button(
        modifier = Modifier.fillMaxWidth().height(50.dp),
        onClick = {
            preferencesManager.saveData("checkInDate", checkInDate)
            preferencesManager.saveData("checkOutDate", checkOutDate)
            preferencesManager.saveData("adults", adults)
            preferencesManager.saveData("children", children)

            viewModel.adults(adults)
            viewModel.children(children)

            if (checkInDate.isNotEmpty()){
                if(checkOutDate.isNotEmpty()) {
                    if (adults.isNotEmpty()) {
                        navController.navigate(route = "hotels_list")
                    } else {
                        Toast.makeText(context, "Adults are empty", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Check Out Date is empty", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Check In Date is empty", Toast.LENGTH_SHORT).show()
            }
        },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Teal)) {
        CustomText(
            text = stringResource(R.string.search),
            fontSize = 18,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            modifier = Modifier,
            textAlign = TextAlign.Center)
    }
}

fun convertMillisToDate(millis: Long): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val date = Date(millis)
    return dateFormat.format(date)
}

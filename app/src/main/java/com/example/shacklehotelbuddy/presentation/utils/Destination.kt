package com.example.shacklehotelbuddy.presentation.utils

sealed class Destination(val route: String) {
    object MainSearchScreen : Destination("main_search_screen")
    object HotelListScreen : Destination("hotel_list_screen")
}
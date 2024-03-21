package com.example.shacklehotelbuddy.features.search.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviIntent

sealed class SearchIntent : IMviIntent {
    data object CheckInDateClicked : SearchIntent()
    data object CheckOutDateClicked : SearchIntent()
}
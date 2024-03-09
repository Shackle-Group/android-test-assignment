package com.example.shacklehotelbuddy.domain.model

sealed class SearchUiError {
    object CheckInError: SearchUiError()
    object CheckOutError: SearchUiError()
    object AdultsError: SearchUiError()
    object ChildrenError: SearchUiError()
}
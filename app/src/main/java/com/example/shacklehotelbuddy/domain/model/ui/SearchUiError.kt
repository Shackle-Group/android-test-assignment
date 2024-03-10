package com.example.shacklehotelbuddy.domain.model.ui

sealed class SearchUiError {
    object CheckInError: SearchUiError()
    object CheckOutError: SearchUiError()
    object AdultsError: SearchUiError()
    object ChildrenError: SearchUiError()
}
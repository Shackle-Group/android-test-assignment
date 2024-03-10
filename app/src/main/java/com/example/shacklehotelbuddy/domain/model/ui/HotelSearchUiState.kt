package com.example.shacklehotelbuddy.domain.model.ui

import com.example.shacklehotelbuddy.data.remote.model.NetworkError

sealed class HotelSearchUiState {
    object None: HotelSearchUiState()
    object InProgress: HotelSearchUiState()
    data class Error(val networkError: NetworkError?): HotelSearchUiState()
    object Done: HotelSearchUiState()
}
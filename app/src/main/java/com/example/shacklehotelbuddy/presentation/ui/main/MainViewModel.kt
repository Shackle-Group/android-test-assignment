package com.example.shacklehotelbuddy.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shacklehotelbuddy.data.mapper.parseSearchDate
import com.example.shacklehotelbuddy.domain.model.Either
import com.example.shacklehotelbuddy.domain.model.Failure
import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import com.example.shacklehotelbuddy.domain.model.SearchDate
import com.example.shacklehotelbuddy.domain.model.SearchUiError
import com.example.shacklehotelbuddy.domain.usecase.CacheHotelSearchUseCase
import com.example.shacklehotelbuddy.domain.usecase.GetCachedHotelSearchesUseCase
import com.example.shacklehotelbuddy.domain.usecase.SearchHotelsUseCase
import com.example.shacklehotelbuddy.presentation.utils.updateCounter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchHotelsUseCase: SearchHotelsUseCase,
    private val cacheHotelSearchUseCase: CacheHotelSearchUseCase,
    private val getCachedHotelSearchesUseCase: GetCachedHotelSearchesUseCase
) : ViewModel() {

    private val initialDate = SearchDate("", "", "")
    private val initialSearch = HotelSearch(initialDate, initialDate, 1, 0)

    private val _hotelSearch = MutableStateFlow(initialSearch)
    val hotelSearch = _hotelSearch.asStateFlow()

    private val _hotelList = MutableStateFlow<List<Hotel>>(emptyList())
    val hotelList = _hotelList.asStateFlow()

    private val _uiState = MutableStateFlow<HotelSearchUiState>(HotelSearchUiState.None)
    val uiState = _uiState.asStateFlow()

    private val _cachedSearchList = MutableStateFlow<List<HotelSearch>>(emptyList())
    val cachedSearchList = _cachedSearchList.asStateFlow()

    private val _error = MutableStateFlow<Failure?>(null)
    val error = _error.asStateFlow()

    init {
        getCachedHotelSearches()
    }

    private fun getCachedHotelSearches() {
        viewModelScope.launch(IO) {
            getCachedHotelSearchesUseCase().collect {
                _cachedSearchList.value = it
            }
        }
    }

    fun searchHotels() {
        getHotels()
        cacheHotelSearch()
    }

    fun searchHistory(hotelSearch: HotelSearch) {
        _hotelSearch.update { hotelSearch }
        getHotels()
    }

    fun getHotels() {
        _uiState.value = HotelSearchUiState.InProgress
        viewModelScope.launch {
            _hotelSearch.value.let { search ->
                searchHotelsUseCase(search).collect { result ->
                    when (result) {
                        is Either.Success -> {
                            _hotelList.value = result.value
                            _uiState.value = HotelSearchUiState.Done
                        }
                        is Either.Fail -> {
                            _error.value = result.value
                            _uiState.value = HotelSearchUiState.Error
                        }
                    }
                }
            }
        }
    }

    private fun cacheHotelSearch() {
        viewModelScope.launch(IO) {
            if (getSearchValidationError() == null) {
                cacheHotelSearchUseCase(_hotelSearch.value)
            }
        }
    }

    fun updateCheckInDate(day: Int, month: Int, year: Int) {
        // check in date has been updated, update state
        _hotelSearch.update {
            it.copy(checkInDate = parseSearchDate(day, month, year))
        }
    }

    fun updateCheckOutDate(day: Int, month: Int, year: Int) {
        // check out date has been updated, update state
        _hotelSearch.update {
            it.copy(checkOutDate = parseSearchDate(day, month, year))
        }
    }

    fun updateAdults(adults: String) {
        runCatching {
            // adults has been updated, update state
            _hotelSearch.update {
                it.copy(adults = adults.toInt())
            }
        }
    }

    fun updateAdults(increment: Boolean) {
        // adults has been updated, update state
        _hotelSearch.update {
            it.copy(adults = it.adults.updateCounter(increment, minValue = 1))
        }
    }

    fun updateChildren(children: String) {
        runCatching {
            // children has been updated, update state
            _hotelSearch.update {
                it.copy(children = children.toInt())
            }
        }
    }

    fun updateChildren(increment: Boolean) {
        // children has been updated, update state
        _hotelSearch.update {
            it.copy(children = it.children.updateCounter(increment))
        }
    }

    fun getSearchValidationError(): SearchUiError? {
        return _hotelSearch.value.let {
            if (it.checkInDate == initialDate) SearchUiError.CheckInError
            else if (it.checkOutDate == initialDate) SearchUiError.CheckOutError
            else if (it.adults < 1) SearchUiError.AdultsError
            else if (it.children < 0) SearchUiError.ChildrenError
            else null
        }
    }
}

sealed class HotelSearchUiState {
    object None: HotelSearchUiState()
    object InProgress: HotelSearchUiState()
    object Error: HotelSearchUiState()
    object Done: HotelSearchUiState()
}

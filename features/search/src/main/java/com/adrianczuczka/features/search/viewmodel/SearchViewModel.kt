package com.adrianczuczka.features.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrianczuczka.data.properties.RecentSearchesRepository
import com.adrianczuczka.data.properties.search.model.DbSearchInfo
import com.adrianczuczka.domain.properties.DbDateInfoMapper
import com.adrianczuczka.features.search.formatter.CurrentTimeFormatter
import com.adrianczuczka.features.search.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val searchesRepository: RecentSearchesRepository,
    private val dbDateInfoMapper: DbDateInfoMapper,
    private val currentTimeFormatter: CurrentTimeFormatter,
) : ViewModel() {

    private val _state: MutableStateFlow<SearchState> = MutableStateFlow(SearchState())

    val state: StateFlow<SearchState> = _state.asStateFlow()

    fun onCheckInButtonClick() =
        _state.update { it.copy(datePickerState = SearchState.DatePickerState.CHECK_IN) }

    fun onCheckOutButtonClick() =
        _state.update { it.copy(datePickerState = SearchState.DatePickerState.CHECK_OUT) }

    fun onCheckInDateChanged(dateMillis: Long) = _state.update {
        it.copy(
            datePickerState = null,
            checkInDate = Date(dateMillis)
        )
    }

    fun onCheckOutDateChanged(dateMillis: Long) = _state.update {
        it.copy(
            datePickerState = null,
            checkOutDate = Date(dateMillis)
        )
    }

    fun onAdultCountChanged(newCount: Int) = _state.update { it.copy(adultCount = newCount) }

    fun onChildrenCountChanged(newCount: Int) = _state.update { it.copy(childrenCount = newCount) }

    fun dismissDatePicker() = _state.update { it.copy(datePickerState = null) }

    fun loadRecentSearches() {
        viewModelScope.launch(dispatcher) {
            val recentSearches = searchesRepository.getRecentSearches()
            _state.update { it.copy(mostRecentSearches = recentSearches) }
        }
    }

    fun storeSearch(
        checkInDateMillis: Long,
        checkOutDateMillis: Long,
        adultCount: Int,
        childrenCount: Int,
    ) {
        viewModelScope.launch(dispatcher) {
            searchesRepository.storeSearch(
                DbSearchInfo(
                    checkInDate = dbDateInfoMapper(checkInDateMillis),
                    checkOutDate = dbDateInfoMapper(checkOutDateMillis),
                    adultCount = adultCount,
                    childrenCount = childrenCount,
                    timestamp = currentTimeFormatter()
                )
            )
        }
    }
}
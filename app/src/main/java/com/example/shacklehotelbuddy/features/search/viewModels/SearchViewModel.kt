package com.example.shacklehotelbuddy.features.search.viewModels

import androidx.lifecycle.viewModelScope
import com.example.shacklehotelbuddy.base.errors.ErrorHandlingUseCase.Companion.processRequestResult
import com.example.shacklehotelbuddy.base.mvi.MviViewModel
import com.example.shacklehotelbuddy.features.hotels.useCases.SearchUseCase
import com.example.shacklehotelbuddy.features.search.mvi.SearchAction
import com.example.shacklehotelbuddy.features.search.mvi.SearchIntent
import com.example.shacklehotelbuddy.features.search.mvi.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : MviViewModel<SearchIntent, SearchState, SearchAction>(
    SearchState.default
) {
    fun doIt() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            searchUseCase.getHotels(
                checkInDate = Calendar.getInstance(),
                checkOutDate = Calendar.getInstance().apply {
                    add(Calendar.DAY_OF_MONTH, 5)
                },
                adultCount = 1,
                childrenCount = 0
            ).processRequestResult(
                action = { data ->
                    println(data)
                },
                failAction = { code, message ->
                    println("Error: $code, $message")
                }
            )
        }
    }
}
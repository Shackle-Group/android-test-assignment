package com.example.shacklehotelbuddy.features.search.viewModels

import androidx.lifecycle.viewModelScope
import com.example.shacklehotelbuddy.base.mvi.MviViewModel
import com.example.shacklehotelbuddy.features.search.api.SearchApiService
import com.example.shacklehotelbuddy.features.search.api.request.CheckDateRequest
import com.example.shacklehotelbuddy.features.search.api.request.ChildRequest
import com.example.shacklehotelbuddy.features.search.api.request.DestinationRequest
import com.example.shacklehotelbuddy.features.search.api.request.FiltersRequest
import com.example.shacklehotelbuddy.features.search.api.request.HotelSearchRequest
import com.example.shacklehotelbuddy.features.search.api.request.PriceRequest
import com.example.shacklehotelbuddy.features.search.api.request.RoomRequest
import com.example.shacklehotelbuddy.features.search.mvi.SearchAction
import com.example.shacklehotelbuddy.features.search.mvi.SearchIntent
import com.example.shacklehotelbuddy.features.search.mvi.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchApiService: SearchApiService
) : MviViewModel<SearchIntent, SearchState, SearchAction>(
    SearchState.default
) {
    fun doIt() = viewModelScope.launch {
        with(Dispatchers.IO) {
            val result = searchApiService.getHotels(
                request = HotelSearchRequest(
                    currency = "USD",
                    eapid = 1,
                    locale = "en_US",
                    siteID = 300000001,
                    destination = DestinationRequest(
                        regionId = "6054439"
                    ),
                    checkInDate = CheckDateRequest(
                        day = 10,
                        month = 10,
                        year = 2022
                    ),
                    checkOutDate = CheckDateRequest(
                        day = 15,
                        month = 10,
                        year = 2022
                    ),
                    rooms = listOf(
                        RoomRequest(
                            adults = 2,
                            children = listOf(
                                ChildRequest(
                                    age = 5
                                ),
                                ChildRequest(
                                    age = 7
                                )
                            )
                        )
                    ),
                    resultsStartingIndex = 0,
                    resultsSize = 1,
                    sort = "PRICE_LOW_TO_HIGH",
                    filters = FiltersRequest(
                        price = PriceRequest(
                            max = 150,
                            min = 100
                        )
                    )
                )
            )
            println(result)
        }
    }
}
package com.example.shacklehotelbuddy.features.hotels.viewModels

import com.example.shacklehotelbuddy.base.mvi.MviViewModel
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsAction
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsIntent
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsState
import com.example.shacklehotelbuddy.features.hotels.useCases.HotelsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Hotels view model.
 *
 * @property hotelsUseCase Hotels use case
 * @constructor Create [HotelsViewModel]
 */
@HiltViewModel
class HotelsViewModel @Inject constructor(
    private val hotelsUseCase: HotelsUseCase
) : MviViewModel<HotelsIntent, HotelsState, HotelsAction>(HotelsState.default) {
    override suspend fun dispatchIntent(intent: HotelsIntent) {
        when (intent) {
            is HotelsIntent.LoadHotels -> loadContent()
            is HotelsIntent.TapToHotel -> openHotelDetails(intent.hotelId)
        }
    }

    /**
     * Load content.
     */
    private suspend fun loadContent() {
        state.value.copy(isLoading = true).emitState()
        hotelsUseCase.getHotelsByLastRequest().processRequestResult(
            successAction = { hotels ->
                state.value.copy(isLoading = false, hotels = hotels).emitState()
            },
            failAction = { code, message ->
                state.value.copy(isLoading = false).emitState()
                action.emit(HotelsAction.ShowError(code, message))
            }
        )
    }

    /**
     * Open screen with hotel details.
     *
     * @param hotelId Hotel id
     */
    private suspend fun openHotelDetails(hotelId: String) {
        action.emit(HotelsAction.OpenHotelDetails(hotelId))
    }
}
package com.example.shacklehotelbuddy.features.hotels.viewModels

import androidx.lifecycle.viewModelScope
import com.example.shacklehotelbuddy.base.errors.ErrorHandlingUseCase.Companion.processRequestResult
import com.example.shacklehotelbuddy.base.mvi.MviViewModel
import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsAction
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsIntent
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsState
import com.example.shacklehotelbuddy.features.hotels.useCases.HotelsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class HotelsViewModel @Inject constructor(
    private val hotelsUseCase: HotelsUseCase
) : MviViewModel<HotelsIntent, HotelsState, HotelsAction>(
    HotelsState.default
) {

    fun loadContent(searchParameters: SearchParameters? = null) = viewModelScope.launch {
        searchParameters ?: return@launch
        withContext(Dispatchers.Default) {
            hotelsUseCase.getHotels(searchParameters).processRequestResult(
                action = { hotels ->
                    state.value.copy(isLoading = false, hotels = hotels).emitState()
                },
                failAction = { code, message ->
                    state.value.copy(isLoading = false).emitState()
                    action.emit(HotelsAction.ShowError(code, message))
                }
            )
        }
    }
}
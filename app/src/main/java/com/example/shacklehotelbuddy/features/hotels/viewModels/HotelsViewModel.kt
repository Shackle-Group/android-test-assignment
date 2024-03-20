package com.example.shacklehotelbuddy.features.hotels.viewModels

import com.example.shacklehotelbuddy.base.mvi.MviViewModel
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsAction
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsIntent
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HotelsViewModel @Inject constructor() : MviViewModel<HotelsIntent, HotelsState, HotelsAction>(
    HotelsState.default
) {

}
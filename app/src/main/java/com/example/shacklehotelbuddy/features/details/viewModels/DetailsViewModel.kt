package com.example.shacklehotelbuddy.features.details.viewModels

import com.example.shacklehotelbuddy.base.mvi.MviViewModel
import com.example.shacklehotelbuddy.features.details.mvi.DetailsAction
import com.example.shacklehotelbuddy.features.details.mvi.DetailsIntent
import com.example.shacklehotelbuddy.features.details.mvi.DetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : MviViewModel<DetailsIntent, DetailsState, DetailsAction>(
    DetailsState.default
) {

}
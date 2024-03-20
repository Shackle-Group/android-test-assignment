package com.example.shacklehotelbuddy.features.search.viewModels

import com.basetrack.btcodriver.base.mvi.models.MviViewModel
import com.example.shacklehotelbuddy.features.search.mvi.SearchAction
import com.example.shacklehotelbuddy.features.search.mvi.SearchIntent
import com.example.shacklehotelbuddy.features.search.mvi.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : MviViewModel<SearchIntent, SearchState, SearchAction>(
    SearchState.default
) {

}
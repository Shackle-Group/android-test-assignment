package com.adrianczuczka.search.viewmodel

import androidx.lifecycle.ViewModel
import com.adrianczuczka.search.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    private val _state: MutableStateFlow<SearchState> = MutableStateFlow(SearchState())

    val state: StateFlow<SearchState> = _state.asStateFlow()


}
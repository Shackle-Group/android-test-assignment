package com.example.shacklehotelbuddy.features.search.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviState

data class SearchState(val id: Int) : IMviState {
    companion object {
        val default =SearchState(id = 0)
    }
}
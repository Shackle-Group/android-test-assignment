package com.example.shacklehotelbuddy.features.hotels.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviState

data class HotelsState(val id: Int) : IMviState {
    companion object {
        val default = HotelsState(id = 0)
    }
}
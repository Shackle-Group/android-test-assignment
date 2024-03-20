package com.example.shacklehotelbuddy.features.details.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviState

data class DetailsState(val id: Int) : IMviState {
    companion object {
        val default =DetailsState(id = 0)
    }
}
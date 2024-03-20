package com.example.shacklehotelbuddy.features.hotels.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.example.shacklehotelbuddy.base.mvi.MviFragment
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsIntent
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsState
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsAction
import com.example.shacklehotelbuddy.features.hotels.ui.HotelsComposeUi
import com.example.shacklehotelbuddy.features.hotels.viewModels.HotelsViewModel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelsFragment : MviFragment<HotelsIntent, HotelsState, HotelsAction, HotelsViewModel>() {
    override val viewModel: HotelsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        ComposeView(requireActivity()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ShackleHotelBuddyTheme {
                    HotelsComposeUi()
                }
            }
        }
}
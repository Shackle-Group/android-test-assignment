package com.example.shacklehotelbuddy.features.details.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.example.shacklehotelbuddy.base.mvi.MviFragment
import com.example.shacklehotelbuddy.features.details.mvi.DetailsAction
import com.example.shacklehotelbuddy.features.details.mvi.DetailsIntent
import com.example.shacklehotelbuddy.features.details.mvi.DetailsState
import com.example.shacklehotelbuddy.features.details.ui.DetailsComposeUi
import com.example.shacklehotelbuddy.features.details.viewModels.DetailsViewModel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : MviFragment<DetailsIntent, DetailsState, DetailsAction, DetailsViewModel>() {
    override val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        ComposeView(requireActivity()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ShackleHotelBuddyTheme {
                    DetailsComposeUi()
                }
            }
        }
}
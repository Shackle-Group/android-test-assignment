package com.example.shacklehotelbuddy.features.search.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.example.shacklehotelbuddy.base.mvi.MviFragment
import com.example.shacklehotelbuddy.features.search.mvi.SearchAction
import com.example.shacklehotelbuddy.features.search.mvi.SearchIntent
import com.example.shacklehotelbuddy.features.search.mvi.SearchState
import com.example.shacklehotelbuddy.features.search.ui.SearchComposeUi
import com.example.shacklehotelbuddy.features.search.viewModels.SearchViewModel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : MviFragment<SearchIntent, SearchState, SearchAction, SearchViewModel>() {
    override val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        ComposeView(requireActivity()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ShackleHotelBuddyTheme {
                    SearchComposeUi()
                }
            }
        }
}
package com.example.shacklehotelbuddy.features.search.viewModels

import com.example.shacklehotelbuddy.base.mvi.MviViewModel
import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters
import com.example.shacklehotelbuddy.features.search.mvi.SearchAction
import com.example.shacklehotelbuddy.features.search.mvi.SearchIntent
import com.example.shacklehotelbuddy.features.search.mvi.SearchState
import com.example.shacklehotelbuddy.features.search.useCases.SearchUseCase
import com.example.shacklehotelbuddy.features.search.useCases.CheckDateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import java.util.Calendar

private const val ADULTS_BY_DEFAULT = 1
private const val CHILDREN_BY_DEFAULT = 0
private const val CONT_OF_LAST_ACTUAL_SEARCHES = 3

/**
 * Search view model.
 *
 * @property searchUseCase Bridge for work with data layer
 * @property checkDateUseCase Factory method to work with [Calendar]
 * @constructor Create [SearchViewModel]
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
    private val checkDateUseCase: CheckDateUseCase
) : MviViewModel<SearchIntent, SearchState, SearchAction>(SearchState.default) {
    override suspend fun dispatchIntent(intent: SearchIntent) {
        when (intent) {
            SearchIntent.LoadDefaultContent -> showDefaultContent()
            is SearchIntent.UpdateCheckInDate -> updateCheckInDate(intent.timestamp)
            is SearchIntent.UpdateCheckOutDate -> updateCheckOutDate(intent.timestamp)
            is SearchIntent.UpdateAdults -> updateAdults(intent.count)
            is SearchIntent.UpdateChildren -> updateChildren(intent.count)
            is SearchIntent.RemainSearchParameters -> remainSearchParameters(intent.searchParameters)
            is SearchIntent.RepeatSearch -> repeatSearch(intent.searchParameters)
            SearchIntent.MakeSearch -> makeSearch()
        }
    }

    /**
     * Show default content.
     */
    private suspend fun showDefaultContent() {
        state.value.copy(
            checkInTimestamp = checkDateUseCase.getDefaultCheckInDate(),
            checkOutTimestamp = checkDateUseCase.getDefaultCheckOutDate(),
            adultCount = ADULTS_BY_DEFAULT,
            childrenCount = CHILDREN_BY_DEFAULT,
            lastActualSearches = searchUseCase.getLastActualSearches(count = CONT_OF_LAST_ACTUAL_SEARCHES)
        ).emitState()
    }

    /**
     * Update check in date.
     *
     * @param checkInTimestamp Check in timestamp
     */
    private suspend fun updateCheckInDate(checkInTimestamp: Long) {
        val newCheckOutDate = checkDateUseCase.getNewCheckOutDate(checkInTimestamp, state.value.checkOutTimestamp)
        state.value.copy(
            checkInTimestamp = checkInTimestamp,
            checkOutTimestamp = newCheckOutDate,
            isBtnActive = newCheckOutDate != null
        ).emitState()
    }

    /**
     * Update check out date.
     *
     * @param checkOutTimestamp Check out timestamp
     */
    private suspend fun updateCheckOutDate(checkOutTimestamp: Long) {
        state.value.copy(checkOutTimestamp = checkOutTimestamp).emitState()
    }

    /**
     * Update adults.
     *
     * @param adults Adults
     */
    private suspend fun updateAdults(adults: Int) {
        state.value.copy(adultCount = adults).emitState()
    }

    /**
     * Update children.
     *
     * @param children Children
     */
    private suspend fun updateChildren(children: Int) {
        state.value.copy(childrenCount = children).emitState()
    }

    /**
     * Remain search parameters.
     *
     * @param searchParameters Search parameters
     * @return [SearchState]
     */
    private suspend fun remainSearchParameters(searchParameters: SearchParameters) = with(searchParameters) {
        state.value.copy(
            checkInTimestamp = checkInTimestamp,
            checkOutTimestamp = checkOutTimestamp,
            adultCount = adultCount,
            childrenCount = childrenCount
        ).emitState()
    }

    /**
     * Repeat search.
     *
     * @param searchParameters Search parameters
     */
    private suspend fun repeatSearch(searchParameters: SearchParameters) = with(searchParameters) {
        state.value.copy(
            checkInTimestamp = checkInTimestamp,
            checkOutTimestamp = checkOutTimestamp,
            adultCount = adultCount,
            childrenCount = childrenCount
        ).emitState()
        makeSearch(searchParameters)
    }

    /**
     * Save and open search results.
     *
     * @return [SearchAction.ShowHotels]
     */
    private suspend fun makeSearch() = with(state.value) {
        searchUseCase.saveSearchParameters(
            SearchParameters(
                checkInTimestamp = checkInTimestamp,
                checkOutTimestamp = checkOutTimestamp ?: 0,
                adultCount = adultCount,
                childrenCount = childrenCount
            )
        )
        SearchAction.ShowHotels.emitAction()
    }

    /**
     * Save and open search results.
     *
     * @param searchParameters Search parameters
     */
    private suspend fun makeSearch(searchParameters: SearchParameters) {
        searchUseCase.saveSearchParameters(searchParameters)
        SearchAction.ShowHotels.emitAction()
    }
}
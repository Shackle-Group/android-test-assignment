package com.example.shacklehotelbuddy.features_home.presentation

import androidx.lifecycle.ViewModel
import com.example.shacklehotelbuddy.core_database.entities.SearchQueryEntity
import com.example.shacklehotelbuddy.features_home.domain.PropertyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import java.util.Date
import java.util.Random
import javax.inject.Inject


data class MyState(
    val checkInDate: Date = Date(),
    val checkoutDate: Date = Date(),
    val adultsCount: Int = 1,
    val childrenCount: Int = 0,
    val searchHistory: List<SearchQueryEntity> = emptyList()
)

@HiltViewModel
class PropertyVm @Inject constructor(private val propertyRepository: PropertyRepository) :
    ViewModel() {
    private val _uiState = MutableStateFlow(MyState())
    val uiState = _uiState.asStateFlow()

    suspend fun getSearchHistory() {
        _uiState.update { currentState ->
            val queries = mutableListOf<SearchQueryEntity>()
            propertyRepository.fetchRecentSearch().collectLatest { q ->
                queries.addAll(q)
            }

            currentState.copy(searchHistory = queries)
        }
    }

    suspend fun addSearchQuery(searchQueryEntity: SearchQueryEntity) {
        propertyRepository.saveRecentSearch(searchQueryEntity)
    }

    fun getQuery() = SearchQueryEntity(
        checkInDate =  uiState.value.checkInDate,
        checkoutDate = uiState.value.checkoutDate,
        adultsCount = uiState.value.adultsCount,
        childrenCount = uiState.value.childrenCount
    )

    fun updateCheckInDate(checkInDate: Date) {
        _uiState.update { currentState ->
            currentState.copy(
                checkInDate = checkInDate
            )
        }
    }
    fun updateCheckoutDate(checkoutDate: Date) {
        _uiState.update { currentState ->
            currentState.copy(
                checkoutDate = checkoutDate
            )
        }
    }

    fun updateAdultsCount(newAdultsCount: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                adultsCount = newAdultsCount
            )
        }
    }

    fun updateChildrenCount(newChildrenCount: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                childrenCount = newChildrenCount
            )
        }
    }




}
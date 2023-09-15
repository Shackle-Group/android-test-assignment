package com.example.shacklehotelbuddy.features_home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shacklehotelbuddy.core_database.entities.SearchQueryEntity
import com.example.shacklehotelbuddy.features_home.data.dto.Property
import com.example.shacklehotelbuddy.features_home.data.dto.SearchRequestDto
import com.example.shacklehotelbuddy.features_home.data.mappers.defaultSearchRequestDto
import com.example.shacklehotelbuddy.features_home.data.mappers.toSearchRequestDto
import com.example.shacklehotelbuddy.features_home.domain.PropertyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject


data class SearchResultsUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val properties: List<Property?>? = emptyList()
)

data class SearchPageState(
    val checkInDate: Date = Date(),
    val checkoutDate: Date = Date(),
    val adultsCount: Int = 1,
    val childrenCount: Int = 0,
    val searchQueries: List<SearchQueryEntity> = emptyList()
)

@HiltViewModel
class PropertyVm @Inject constructor(private val propertyRepository: PropertyRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(SearchPageState())
    val uiState = _uiState.asStateFlow()

    private val _uiResultState = MutableStateFlow(SearchResultsUiState())
    val uiResultState = _uiResultState.asStateFlow()

    var searchQueryEntity: SearchQueryEntity? = null

    init {
        _uiResultState.update {
            it.copy(isLoading = true)
        }
    }

    suspend fun fetchRecentSearch() {
        _uiState.update { currentState ->
            val queries = mutableListOf<SearchQueryEntity>()
            propertyRepository.fetchRecentSearch().collectLatest { q ->
                queries.addAll(q)
            }

            currentState.copy(searchQueries = queries)
        }
    }

    suspend fun fetchProperties() {

        val searchQuery: SearchRequestDto =
            searchQueryEntity?.toSearchRequestDto() ?: defaultSearchRequestDto()

        propertyRepository.fetchProperties(searchQuery)
            .catch {
                _uiResultState.update {
                    it.copy(errorMessage = it.errorMessage.toString(), properties = null)
                }

                Log.e("PropertyVm", it.message.toString())
            }
            .collectLatest { p ->
                Log.d(
                    "PropertyVm",
                    "PropertyVm: ${p.count()}"
                )
                _uiResultState.update {
                    it.copy(isLoading = false, properties = p)
                }
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

    fun addSearchQuery(searchQueryEntity: SearchQueryEntity) {
        viewModelScope.launch {
            propertyRepository.saveRecentSearch(searchQueryEntity)
        }
    }

    fun getQuery(): SearchQueryEntity {
        val q = SearchQueryEntity(
            checkInDate = uiState.value.checkInDate,
            checkoutDate = uiState.value.checkoutDate,
            adultsCount = uiState.value.adultsCount,
            childrenCount = uiState.value.childrenCount
        )
        searchQueryEntity = q
        return q
    }

    fun getSearchRequestDto() = searchQueryEntity?.toSearchRequestDto()

    fun updateCheckInDate(checkInDate: Date) {
        _uiState.update { currentState ->
            currentState.copy(
                checkInDate = checkInDate
            )
        }
    }


}
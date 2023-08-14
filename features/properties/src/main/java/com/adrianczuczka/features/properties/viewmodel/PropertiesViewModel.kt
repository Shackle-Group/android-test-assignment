package com.adrianczuczka.features.properties.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.adrianczuczka.domain.properties.GetPagingSourceUseCase
import com.adrianczuczka.domain.properties.GetRemoteMediatorUseCase
import com.adrianczuczka.features.properties.model.PropertyListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Currency
import javax.inject.Inject

@HiltViewModel
class PropertiesViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getRemoteMediatorUseCase: GetRemoteMediatorUseCase,
    getPagingSourceUseCase: GetPagingSourceUseCase,
) : ViewModel() {

    private val checkInDateMillis: Long = checkNotNull(savedStateHandle["checkInDate"])
    private val checkOutDateMillis: Long = checkNotNull(savedStateHandle["checkOutDate"])
    private val adultsCount: Int = checkNotNull(savedStateHandle["adultsCount"])
    private val childrenCount: Int = checkNotNull(savedStateHandle["childrenCount"])

    @OptIn(ExperimentalPagingApi::class)
    val properties: Flow<PagingData<PropertyListItem>> =
        Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = getRemoteMediatorUseCase(
                checkInDateMillis,
                checkOutDateMillis,
                adultsCount,
                childrenCount
            ),
            pagingSourceFactory = {
                getPagingSourceUseCase(
                    checkInDateMillis,
                    checkOutDateMillis,
                    adultsCount,
                    childrenCount
                )
            }
        )
            .flow
            .cachedIn(viewModelScope)
            .map { pagingData ->
                pagingData.map { dbProperty ->
                    PropertyListItem(
                        id = dbProperty.id,
                        title = dbProperty.name,
                        subtitle = "",
                        dailyRate = PropertyListItem.DailyRate(
                            rate = 0,
                            currency = Currency.getInstance("USD")
                        ),
                        rating = 0.0,
                        imageUrl = ""
                    )
                }
            }
}
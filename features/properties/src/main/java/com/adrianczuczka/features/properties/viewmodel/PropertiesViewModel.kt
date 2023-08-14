package com.adrianczuczka.features.properties.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.adrianczuczka.domain.properties.GetPagingSourceUseCase
import com.adrianczuczka.features.properties.model.PropertyListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PropertiesViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    savedStateHandle: SavedStateHandle,
    getPagingSourceUseCase: GetPagingSourceUseCase,
) : ViewModel() {

    private val checkInDateMillis: Long by lazy { checkNotNull(savedStateHandle["checkInDate"]) }
    private val checkOutDateMillis: Long by lazy { checkNotNull(savedStateHandle["checkOutDate"]) }
    private val adultsCount: Int by lazy { checkNotNull(savedStateHandle["adultsCount"]) }
    private val childrenCount: Int by lazy { checkNotNull(savedStateHandle["childrenCount"]) }

    val properties: Flow<PagingData<PropertyListItem>> by lazy {
        Pager(
            config = PagingConfig(pageSize = 20),
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
                pagingData.map { apiProperty ->
                    PropertyListItem(
                        id = apiProperty.id,
                        title = apiProperty.name,
                        subtitle = apiProperty.neighborhood.name,
                        dailyRate = apiProperty.price.lead.formatted,
                        rating = apiProperty.reviews.score,
                        imageUrl = apiProperty.propertyImage.image.url
                    )
                }
            }
            .flowOn(dispatcher)
    }
}
package com.adrianczuczka.features.properties.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.paging.testing.asPagingSourceFactory
import androidx.paging.testing.asSnapshot
import com.adrianczuczka.data.properties.remote.model.ApiProperty
import com.adrianczuczka.domain.properties.GetPagingSourceUseCase
import com.adrianczuczka.features.properties.model.PropertyListItem
import com.adrianczuczka.features.properties.util.MainDispatcherRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class PropertiesViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val savedStateHandle: SavedStateHandle = mock()
    private val getPagingSourceUseCase: GetPagingSourceUseCase = mock()

    private lateinit var viewModel: PropertiesViewModel

    @Before
    fun `set up`() {
        viewModel = PropertiesViewModel(
            dispatcher = UnconfinedTestDispatcher(),
            savedStateHandle = savedStateHandle,
            getPagingSourceUseCase = getPagingSourceUseCase
        )
    }

    @Test
    fun `getEvents - returns ui formed events`() = runTest {
        val id = "test id"
        val name = "test name"
        val address = "test address"
        val price = "test price"
        val score = 4.2
        val imageUrl = "test image url"
        val apiProperty = ApiProperty(
            id = id,
            name = name,
            neighborhood = ApiProperty.Neighborhood(
                name = address
            ),
            price = ApiProperty.Price(
                lead = ApiProperty.Price.Lead(
                    formatted = price
                )
            ),
            reviews = ApiProperty.Reviews(score = score),
            propertyImage = ApiProperty.PropertyImage(
                image = ApiProperty.PropertyImage.Image(
                    url = imageUrl
                )
            )
        )
        val propertyListItem = PropertyListItem(
            id = id,
            title = name,
            subtitle = address,
            dailyRate = price,
            rating = score,
            imageUrl = imageUrl
        )
        val checkInDateMillis = 12L
        val checkOutDateMillis = 123L
        val adultsCount = 1234
        val childrenCount = 12345

        whenever(savedStateHandle.get<Long>("checkInDate")).thenReturn(checkInDateMillis)
        whenever(savedStateHandle.get<Long>("checkOutDate")).thenReturn(checkOutDateMillis)
        whenever(savedStateHandle.get<Int>("adultsCount")).thenReturn(adultsCount)
        whenever(savedStateHandle.get<Int>("childrenCount")).thenReturn(childrenCount)

        whenever(
            getPagingSourceUseCase(
                checkInDateMillis = checkInDateMillis,
                checkOutDateMillis = checkOutDateMillis,
                adultsCount = adultsCount,
                childrenCount = childrenCount
            )
        ).thenReturn(
            listOf(apiProperty).asPagingSourceFactory()()
        )

        val items = viewModel.properties.asSnapshot { }

        assertThat(listOf(propertyListItem)).isEqualTo(items)
    }
}
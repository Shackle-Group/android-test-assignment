package com.example.shacklehotelbuddy.ui.view_model

import ShackleHotelBuddy.R
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shacklehotelbuddy.data.event.ServerResponse
import com.example.shacklehotelbuddy.data.model.CheckInDateX
import com.example.shacklehotelbuddy.data.model.CheckOutDateX
import com.example.shacklehotelbuddy.data.model.Children
import com.example.shacklehotelbuddy.data.model.Destination
import com.example.shacklehotelbuddy.data.model.HotelRequest
import com.example.shacklehotelbuddy.data.model.Room
import com.example.shacklehotelbuddy.data.repository.HotelRepository
import com.example.shacklehotelbuddy.ui.event.HotelEvent
import com.example.shacklehotelbuddy.ui.model.FormData
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val hotelRepository: HotelRepository) : ViewModel() {

    private val hotelChannel = Channel<HotelEvent>()
    internal val hotelEvent = hotelChannel.receiveAsFlow()
    private val _formData : FormData = FormData("","", "", "")

    fun checkIntDate(checkInDate: String) {
        _formData.checkInDate = checkInDate
    }

    fun checkOutDate(checkOutDate: String) {
        _formData.checkOutDate = checkOutDate
    }

    fun adults(adults: String) {
        _formData.adults = adults
    }

    fun children(children: String) {
        _formData.children = children
    }

    fun resetFormData() {
        _formData.adults = ""
        _formData.children = ""
        _formData.checkOutDate = ""
        _formData.checkInDate = ""
    }


    internal fun getHotelList() =
        viewModelScope.launch {
        hotelChannel.send(HotelEvent.Loading)
        val room = Room(_formData.adults.toInt(),
            listOf(Children(5)))
        val request = HotelRequest(
            resultsStartingIndex = 0,
            resultsSize = 20,
            destination = Destination(context.getString(R.string.region_id)),
            checkInDate = CheckInDateX(_formData.checkInDate.substringBefore("/").toInt(),
                _formData.checkInDate.substringAfter("/").substringBefore("/").toInt(),
                _formData.checkInDate.substringAfterLast("/").toInt()
            ),
            checkOutDate = CheckOutDateX(_formData.checkOutDate.substringBefore("/").toInt(),
                _formData.checkOutDate.substringAfter("/").substringBefore("/").toInt(),
                _formData.checkOutDate.substringAfterLast("/").toInt()
            ),
            rooms = arrayListOf(room),
        )
        hotelRepository.getHotelList(request).collect {
            when (it) {
                is ServerResponse.Error -> hotelChannel.send(HotelEvent.Error(it.error))
                is ServerResponse.Success -> hotelChannel.send(HotelEvent.Success(it.data))
            }
        }
    }
}
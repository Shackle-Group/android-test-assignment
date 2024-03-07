package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class ResolvedDateRange(
    @SerializedName("checkOutDate")
    val checkOutDate: CheckOutDateXX,
    @SerializedName("__typename")
    val typename: String
)
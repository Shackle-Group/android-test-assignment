package com.example.shacklehotelbuddy.data.model

import com.google.gson.annotations.SerializedName

data class ShoppingContext(
    @SerializedName("multiItem")
    val multiItem: Any,
    @SerializedName("__typename")
    val typename: String
)
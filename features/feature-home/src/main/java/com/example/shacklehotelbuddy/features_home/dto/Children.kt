package com.example.shacklehotelbuddy.features_home.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import android.support.annotation.Keep

@Keep
@Serializable
data class Children(
    @SerialName("age")
    val age: Int?
)
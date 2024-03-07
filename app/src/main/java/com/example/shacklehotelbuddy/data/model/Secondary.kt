package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Secondary(
    @SerializedName("icon_temp")
    val iconTemp: IconTemp,
    @SerializedName("mark")
    val mark: Any,
    @SerializedName("text")
    val text: String,
    @SerializedName("theme_temp")
    val themeTemp: String,
    @SerializedName("__typename")
    val typename: String
)
package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class FieldX(
    @SerializedName("dropdownFilterOptions")
    val dropdownFilterOptions: List<DropdownFilterOption>,
    @SerializedName("primary")
    val primary: String,
    @SerializedName("secondary")
    val secondary: Any,
    @SerializedName("__typename")
    val typename: String
)
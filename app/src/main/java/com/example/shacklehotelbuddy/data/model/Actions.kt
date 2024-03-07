package com.example.shacklehotelbuddy.data.model

import com.google.gson.annotations.SerializedName

data class Actions(
    @SerializedName("primary")
    val primary: PrimaryXX,
    @SerializedName("secondaries")
    val secondaries: List<SecondaryXX>,
    @SerializedName("__typename")
    val typename: String
)
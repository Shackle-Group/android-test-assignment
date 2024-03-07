package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Toolbar(
    @SerializedName("actions")
    val actions: Actions,
    @SerializedName("primary")
    val primary: String,
    @SerializedName("__typename")
    val typename: String
)
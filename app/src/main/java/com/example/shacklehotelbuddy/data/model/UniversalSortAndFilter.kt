package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class UniversalSortAndFilter(
    @SerializedName("applyAction")
    val applyAction: ApplyAction,
    @SerializedName("filterSections")
    val filterSections: List<FilterSection>,
    @SerializedName("revealAction")
    val revealAction: RevealAction,
    @SerializedName("sortSections")
    val sortSections: List<SortSection>,
    @SerializedName("toolbar")
    val toolbar: Toolbar,
    @SerializedName("__typename")
    val typename: String
)
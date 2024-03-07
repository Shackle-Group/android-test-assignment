package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Field(
    @SerializedName("action")
    val action: Action,
    @SerializedName("analytics")
    val analytics: Analytics,
    @SerializedName("expando")
    val expando: Expando,
    @SerializedName("icon")
    val icon: Icon,
    @SerializedName("id")
    val id: String,
    @SerializedName("label")
    val label: Any,
    @SerializedName("multiSelectionOptions")
    val multiSelectionOptions: List<MultiSelectionOption>,
    @SerializedName("options")
    val options: List<OptionXXXX>,
    @SerializedName("placeholder")
    val placeholder: String,
    @SerializedName("primary")
    val primary: String,
    @SerializedName("range")
    val range: Range,
    @SerializedName("secondary")
    val secondary: Any,
    @SerializedName("selected")
    val selected: Any,
    @SerializedName("tileMultiSelectionOptions")
    val tileMultiSelectionOptions: List<TileMultiSelectionOption>,
    @SerializedName("typeaheadInfo")
    val typeaheadInfo: TypeaheadInfo,
    @SerializedName("__typename")
    val typename: String
)
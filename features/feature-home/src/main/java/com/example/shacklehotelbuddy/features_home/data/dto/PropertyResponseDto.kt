package com.example.shacklehotelbuddy.features_home.data.dto


import android.media.Image
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import java.util.Objects


@Keep
@Serializable
data class PropertyResponseDto(
    @SerializedName("data")
    val data: Data?
)

@Keep
@Serializable
data class Data(
    @SerializedName("propertySearch")
    val propertySearch: PropertySearch?
) {
    @Keep
    @Serializable
    data class PropertySearch(
        @SerializedName("properties")
        val properties: List<Property?>?,
        @SerializedName("clickstream")
        val clickStream: ClickStream?
    )
}

@Keep
@Serializable
data class Property(
    @SerializedName("availability")
    val availability: Availability?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("mapMarker")
    val mapMarker: MapMarker?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Price?,
    @SerializedName("priceAfterLoyaltyPointsApplied")
    val priceAfterLoyaltyPointsApplied: PriceAfterLoyaltyPointsApplied?,
    @SerializedName("priceMessages")
    val priceMetadata: PriceMetadata?,
    @SerializedName("propertyImage")
    val propertyImage: PropertyImage?,
    @SerializedName("regionId")
    val regionId: String?,
    @SerializedName("reviews")
    val reviews: Reviews?,

    )

@Keep
@Serializable
data class Availability(
    @SerializedName("available")
    val available: Boolean?,
    @SerializedName("minRoomsLeft")
    val minRoomsLeft: Int?,
    @SerializedName("__typename")
    val typename: String?
)

@Keep
@Serializable
data class MapMarker(
    @SerializedName("label")
    val label: String?,
    @SerializedName("latLong")
    val latLong: LatLong?,
    @SerializedName("__typename")
    val typename: String?
) {
    @Keep
    @Serializable
    data class LatLong(
        @SerializedName("latitude")
        val latitude: Double?,
        @SerializedName("longitude")
        val longitude: Double?,
        @SerializedName("__typename")
        val typename: String?
    )
}

@Keep
@Serializable
data class Price(
    @SerializedName("displayMessages")
    val displayMessages: List<DisplayMessage?>?,
    @SerializedName("lead")
    val lead: Lead?,
    @SerializedName("options")
    val options: List<Option?>?,
    @SerializedName("priceMessages")
    val priceMessages: List<PriceMessage?>?,
    @SerializedName("priceMessaging")
    val priceMessaging: String?,
    @SerializedName("strikeOut")
    val strikeOut: StrikeOut?,
    @SerializedName("strikeOutType")
    val strikeOutType: String?,
    @SerializedName("__typename")
    val typename: String?
) {
    @Keep
    @Serializable
    data class DisplayMessage(
        @SerializedName("lineItems")
        val lineItems: List<LineItem?>?,
        @SerializedName("__typename")
        val typename: String?
    )

    @Keep
    @Serializable
    data class LineItem(
        @SerializedName("accessibilityLabel")
        val accessibilityLabel: String?,
        @SerializedName("price")
        val price: Price?,
        @SerializedName("role")
        val role: String?,

        @SerializedName("__typename")
        val typename: String?,
        @SerializedName("value")
        val value: String?
    )
    @Keep
    @Serializable
    data class PriceX(
        @SerializedName("accessibilityLabel")
        val accessibilityLabel: String?,
        @SerializedName("formatted")
        val formatted: String?,
        @SerializedName("__typename")
        val typename: String?
    )

    @Keep
    @Serializable
    data class Lead(
        @SerializedName("amount")
        val amount: Double?,
        @SerializedName("currencyInfo")
        val currencyInfo: CurrencyInfo?,
        @SerializedName("formatted")
        val formatted: String?,
        @SerializedName("__typename")
        val typename: String?
    )

    @Keep
    @Serializable
    data class CurrencyInfo(
        @SerializedName("code")
        val code: String?,
        @SerializedName("symbol")
        val symbol: String?,
        @SerializedName("__typename")
        val typename: String?
    )

    @Keep
    @Serializable
    data class Option(
        @SerializedName("disclaimer")
        val disclaimer: Disclaimer?,
        @SerializedName("formattedDisplayPrice")
        val formattedDisplayPrice: String?,
        @SerializedName("strikeOut")
        val strikeOut: StrikeOut?,
        @SerializedName("__typename")
        val typename: String?
    )

    @Keep
    @Serializable
    data class Disclaimer(
        @SerializedName("__typename")
        val typename: String?,
        @SerializedName("value")
        val value: String?
    )

    @Keep
    @Serializable
    data class StrikeOut(
        @SerializedName("amount")
        val amount: Double?,
        @SerializedName("formatted")
        val formatted: String?,
        @SerializedName("__typename")
        val typename: String?
    )

    @Keep
    @Serializable
    data class PriceMessage(
        @SerializedName("__typename")
        val typename: String?,
        @SerializedName("value")
        val value: String?
    )
}

@Keep
@Serializable
data class PriceAfterLoyaltyPointsApplied(
    @SerializedName("lead")
    val lead: Lead?,
    @SerializedName("options")
    val options: List<Option?>?,
    @SerializedName("__typename")
    val typename: String?
)

@Keep
@Serializable
data class Lead(
    @SerializedName("amount")
    val amount: Double?,
    @SerializedName("currencyInfo")
    val currencyInfo: CurrencyInfo?,
    @SerializedName("formatted")
    val formatted: String?,
    @SerializedName("__typename")
    val typename: String?
) {
    @Keep
    @Serializable
    data class CurrencyInfo(
        @SerializedName("code")
        val code: String?,
        @SerializedName("symbol")
        val symbol: String?,
        @SerializedName("__typename")
        val typename: String?
    )
    }

    @Keep
    @Serializable
    data class Option(
        @SerializedName("formattedDisplayPrice")
        val formattedDisplayPrice: String?,
        @SerializedName("__typename")
        val typename: String?
    )


@Keep
@Serializable
data class PriceMetadata(
    @SerializedName("value")
    val value: String?,
    @SerializedName("__typename")
    val typename: String?
)

@Keep
@Serializable
data class RateDiscount(
    @SerializedName("description")
    val description: String?,
    @SerializedName("__typename")
    val typename: String?
)

@Keep
@Serializable
data class PropertyImage(
    @SerializedName("alt")
    val alt: String?,
    @SerializedName("fallbackImage")
    val fallbackImage: String?,
    @SerializedName("image")
    val image: ImageXX?,
    @SerializedName("subjectId")
    val subjectId: Int?,
    @SerializedName("__typename")
    val typename: String?
)

@Keep
@Serializable
data class ImageXX(
    @SerializedName("description")
    val description: String?,
    @SerializedName("__typename")
    val typename: String?,
    @SerializedName("url")
    val url: String?
)


@Keep
@Serializable
data class Reviews(
    @SerializedName("score")
    val score: Double?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("__typename")
    val typename: String?
)

@Keep
@Serializable
data class ClickStream(
    @SerializedName("searchResultsViewed")
    val searchResultsViewed: String?,
    @SerializedName("__typename")
    val typename: String?
)



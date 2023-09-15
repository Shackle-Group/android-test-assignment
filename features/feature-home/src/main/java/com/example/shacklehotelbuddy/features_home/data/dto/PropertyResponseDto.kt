package com.example.shacklehotelbuddy.features_home.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import android.support.annotation.Keep

@Keep
@Serializable
data class PropertyResponseDto(
    @SerialName("data")
    val `data`: Data?
) {
    @Keep
    @Serializable
    data class Data(
        @SerialName("propertySearch")
        val propertySearch: PropertySearch?
    ) {
        @Keep
        @Serializable
        data class PropertySearch(
            @SerialName("properties")
            val properties: List<Property?>?
        ) {
            @Keep
            @Serializable
            data class Property(
                @SerialName("availability")
                val availability: Availability?,
                @SerialName("id")
                val id: String?,
                @SerialName("legalDisclaimer")
                val legalDisclaimer: Any?,
                @SerialName("mapMarker")
                val mapMarker: MapMarker?,
                @SerialName("name")
                val name: String?,
                @SerialName("offerSummary")
                val offerSummary: OfferSummary?,
                @SerialName("price")
                val price: Price?,
                @SerialName("priceAfterLoyaltyPointsApplied")
                val priceAfterLoyaltyPointsApplied: PriceAfterLoyaltyPointsApplied?,
                @SerialName("priceMetadata")
                val priceMetadata: PriceMetadata?,
                @SerialName("propertyImage")
                val propertyImage: PropertyImage?,
                @SerialName("regionId")
                val regionId: String?,
                @SerialName("reviews")
                val reviews: Reviews?,
                @SerialName("star")
                val star: Any?,
                @SerialName("supportingMessages")
                val supportingMessages: Any?
            ) {
                @Keep
                @Serializable
                data class Availability(
                    @SerialName("available")
                    val available: Boolean?,
                    @SerialName("minRoomsLeft")
                    val minRoomsLeft: Int?,
                    @SerialName("__typename")
                    val typename: String?
                )

                @Keep
                @Serializable
                data class MapMarker(
                    @SerialName("label")
                    val label: String?,
                    @SerialName("latLong")
                    val latLong: LatLong?,
                    @SerialName("__typename")
                    val typename: String?
                ) {
                    @Keep
                    @Serializable
                    data class LatLong(
                        @SerialName("latitude")
                        val latitude: Double?,
                        @SerialName("longitude")
                        val longitude: Double?,
                        @SerialName("__typename")
                        val typename: String?
                    )
                }

                @Keep
                @Serializable
                data class OfferSummary(
                    @SerialName("attributes")
                    val attributes: List<Any?>?,
                    @SerialName("messages")
                    val messages: List<Any?>?,
                    @SerialName("__typename")
                    val typename: String?
                )

                @Keep
                @Serializable
                data class Price(
                    @SerialName("displayMessages")
                    val displayMessages: List<DisplayMessage?>?,
                    @SerialName("lead")
                    val lead: Lead?,
                    @SerialName("options")
                    val options: List<Option?>?,
                    @SerialName("priceMessages")
                    val priceMessages: List<PriceMessage?>?,
                    @SerialName("priceMessaging")
                    val priceMessaging: Any?,
                    @SerialName("strikeOut")
                    val strikeOut: StrikeOut?,
                    @SerialName("strikeOutType")
                    val strikeOutType: String?,
                    @SerialName("__typename")
                    val typename: String?
                ) {
                    @Keep
                    @Serializable
                    data class DisplayMessage(
                        @SerialName("lineItems")
                        val lineItems: List<LineItem?>?,
                        @SerialName("__typename")
                        val typename: String?
                    ) {
                        @Keep
                        @Serializable
                        data class LineItem(
                            @SerialName("accessibilityLabel")
                            val accessibilityLabel: Any?,
                            @SerialName("badge")
                            val badge: Any?,
                            @SerialName("disclaimer")
                            val disclaimer: Disclaimer?,
                            @SerialName("mark")
                            val mark: Any?,
                            @SerialName("price")
                            val price: Price?,
                            @SerialName("role")
                            val role: String?,
                            @SerialName("state")
                            val state: Any?,
                            @SerialName("__typename")
                            val typename: String?,
                            @SerialName("value")
                            val value: String?
                        ) {
                            @Keep
                            @Serializable
                            data class Disclaimer(
                                @SerialName("content")
                                val content: List<String?>?,
                                @SerialName("title")
                                val title: Any?,
                                @SerialName("__typename")
                                val typename: String?
                            )

                            @Keep
                            @Serializable
                            data class Price(
                                @SerialName("accessibilityLabel")
                                val accessibilityLabel: String?,
                                @SerialName("formatted")
                                val formatted: String?,
                                @SerialName("__typename")
                                val typename: String?
                            )
                        }
                    }

                    @Keep
                    @Serializable
                    data class Lead(
                        @SerialName("amount")
                        val amount: Double?,
                        @SerialName("currencyInfo")
                        val currencyInfo: CurrencyInfo?,
                        @SerialName("formatted")
                        val formatted: String?,
                        @SerialName("__typename")
                        val typename: String?
                    ) {
                        @Keep
                        @Serializable
                        data class CurrencyInfo(
                            @SerialName("code")
                            val code: String?,
                            @SerialName("symbol")
                            val symbol: String?,
                            @SerialName("__typename")
                            val typename: String?
                        )
                    }

                    @Keep
                    @Serializable
                    data class Option(
                        @SerialName("disclaimer")
                        val disclaimer: Disclaimer?,
                        @SerialName("formattedDisplayPrice")
                        val formattedDisplayPrice: String?,
                        @SerialName("strikeOut")
                        val strikeOut: StrikeOut?,
                        @SerialName("__typename")
                        val typename: String?
                    ) {
                        @Keep
                        @Serializable
                        data class Disclaimer(
                            @SerialName("__typename")
                            val typename: String?,
                            @SerialName("value")
                            val value: String?
                        )

                        @Keep
                        @Serializable
                        data class StrikeOut(
                            @SerialName("amount")
                            val amount: Double?,
                            @SerialName("formatted")
                            val formatted: String?,
                            @SerialName("__typename")
                            val typename: String?
                        )
                    }

                    @Keep
                    @Serializable
                    data class PriceMessage(
                        @SerialName("__typename")
                        val typename: String?,
                        @SerialName("value")
                        val value: String?
                    )

                    @Keep
                    @Serializable
                    data class StrikeOut(
                        @SerialName("amount")
                        val amount: Double?,
                        @SerialName("currencyInfo")
                        val currencyInfo: CurrencyInfo?,
                        @SerialName("formatted")
                        val formatted: String?,
                        @SerialName("__typename")
                        val typename: String?
                    ) {
                        @Keep
                        @Serializable
                        data class CurrencyInfo(
                            @SerialName("code")
                            val code: String?,
                            @SerialName("symbol")
                            val symbol: String?,
                            @SerialName("__typename")
                            val typename: String?
                        )
                    }
                }

                @Keep
                @Serializable
                data class PriceAfterLoyaltyPointsApplied(
                    @SerialName("lead")
                    val lead: Lead?,
                    @SerialName("options")
                    val options: List<Option?>?,
                    @SerialName("__typename")
                    val typename: String?
                ) {
                    @Keep
                    @Serializable
                    data class Lead(
                        @SerialName("amount")
                        val amount: Double?,
                        @SerialName("currencyInfo")
                        val currencyInfo: CurrencyInfo?,
                        @SerialName("formatted")
                        val formatted: String?,
                        @SerialName("__typename")
                        val typename: String?
                    ) {
                        @Keep
                        @Serializable
                        data class CurrencyInfo(
                            @SerialName("code")
                            val code: String?,
                            @SerialName("symbol")
                            val symbol: String?,
                            @SerialName("__typename")
                            val typename: String?
                        )
                    }

                    @Keep
                    @Serializable
                    data class Option(
                        @SerialName("disclaimer")
                        val disclaimer: Disclaimer?,
                        @SerialName("formattedDisplayPrice")
                        val formattedDisplayPrice: String?,
                        @SerialName("strikeOut")
                        val strikeOut: StrikeOut?,
                        @SerialName("__typename")
                        val typename: String?
                    ) {
                        @Keep
                        @Serializable
                        data class Disclaimer(
                            @SerialName("__typename")
                            val typename: String?,
                            @SerialName("value")
                            val value: String?
                        )

                        @Keep
                        @Serializable
                        data class StrikeOut(
                            @SerialName("amount")
                            val amount: Double?,
                            @SerialName("formatted")
                            val formatted: String?,
                            @SerialName("__typename")
                            val typename: String?
                        )
                    }
                }

                @Keep
                @Serializable
                data class PriceMetadata(
                    @SerialName("discountType")
                    val discountType: String?,
                    @SerialName("rateDiscount")
                    val rateDiscount: RateDiscount?,
                    @SerialName("totalDiscountPercentage")
                    val totalDiscountPercentage: Int?,
                    @SerialName("__typename")
                    val typename: String?
                ) {
                    @Keep
                    @Serializable
                    data class RateDiscount(
                        @SerialName("description")
                        val description: String?,
                        @SerialName("__typename")
                        val typename: String?
                    )
                }

                @Keep
                @Serializable
                data class PropertyImage(
                    @SerialName("alt")
                    val alt: String?,
                    @SerialName("fallbackImage")
                    val fallbackImage: Any?,
                    @SerialName("image")
                    val image: Image?,
                    @SerialName("subjectId")
                    val subjectId: Int?,
                    @SerialName("__typename")
                    val typename: String?
                ) {
                    @Keep
                    @Serializable
                    data class Image(
                        @SerialName("description")
                        val description: String?,
                        @SerialName("__typename")
                        val typename: String?,
                        @SerialName("url")
                        val url: String?
                    )
                }

                @Keep
                @Serializable
                data class Reviews(
                    @SerialName("score")
                    val score: Int?,
                    @SerialName("total")
                    val total: Int?,
                    @SerialName("__typename")
                    val typename: String?
                )
            }
        }
    }
}
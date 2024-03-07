package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PropertySearchListings(
    @SerializedName("destinationInfo")
    val destinationInfo: DestinationInfoX,
    @SerializedName("featuredMessages")
    val featuredMessages: List<Any>,
    @SerializedName("id")
    val id: String,
    @SerializedName("legalDisclaimer")
    val legalDisclaimer: Any,
    @SerializedName("listingFooter")
    val listingFooter: Any,
    @SerializedName("mapMarker")
    val mapMarker: MapMarkerX,
    @SerializedName("name")
    val name: String,
    @SerializedName("offerBadge")
    val offerBadge: OfferBadgeX,
    @SerializedName("offerSummary")
    val offerSummary: OfferSummaryX,
    @SerializedName("pinnedDetails")
    val pinnedDetails: Any,
    @SerializedName("price")
    val price: PriceXX,
    @SerializedName("priceAfterLoyaltyPointsApplied")
    val priceAfterLoyaltyPointsApplied: PriceAfterLoyaltyPointsAppliedX,
    @SerializedName("priceMetadata")
    val priceMetadata: PriceMetadataX,
    @SerializedName("propertyFees")
    val propertyFees: List<Any>,
    @SerializedName("propertyImage")
    val propertyImage: PropertyImageX,
    @SerializedName("regionId")
    val regionId: String,
    @SerializedName("saveTripItem")
    val saveTripItem: SaveTripItemX,
    @SerializedName("sponsoredListing")
    val sponsoredListing: SponsoredListingX,
    @SerializedName("star")
    val star: Any,
    @SerializedName("supportingMessages")
    val supportingMessages: Any,
    @SerializedName("__typename")
    val typename: String
)
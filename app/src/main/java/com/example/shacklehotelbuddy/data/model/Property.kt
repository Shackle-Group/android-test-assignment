package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Property(
    @SerializedName("availability")
    val availability: Availability,
    @SerializedName("destinationInfo")
    val destinationInfo: DestinationInfo,
    @SerializedName("featuredMessages")
    val featuredMessages: List<Any>,
    @SerializedName("id")
    val id: String,
    @SerializedName("legalDisclaimer")
    val legalDisclaimer: Any,
    @SerializedName("listingFooter")
    val listingFooter: Any,
    @SerializedName("mapMarker")
    val mapMarker: MapMarker,
    @SerializedName("name")
    val name: String,
    @SerializedName("neighborhood")
    val neighborhood: NeighborhoodX,
    @SerializedName("offerBadge")
    val offerBadge: OfferBadge,
    @SerializedName("offerSummary")
    val offerSummary: OfferSummary,
    @SerializedName("pinnedDetails")
    val pinnedDetails: Any,
    @SerializedName("price")
    val price: Price,
    @SerializedName("priceAfterLoyaltyPointsApplied")
    val priceAfterLoyaltyPointsApplied: PriceAfterLoyaltyPointsApplied,
    @SerializedName("priceMetadata")
    val priceMetadata: PriceMetadata,
    @SerializedName("propertyFees")
    val propertyFees: List<Any>,
    @SerializedName("propertyImage")
    val propertyImage: PropertyImage,
    @SerializedName("regionId")
    val regionId: String,
    @SerializedName("reviews")
    val reviews: Reviews,
    @SerializedName("saveTripItem")
    val saveTripItem: SaveTripItem,
    @SerializedName("sponsoredListing")
    val sponsoredListing: SponsoredListing,
    @SerializedName("star")
    val star: Any,
    @SerializedName("supportingMessages")
    val supportingMessages: Any,
    @SerializedName("__typename")
    val typename: String
)
package com.halmg.robouniver.data.api

import com.google.gson.annotations.SerializedName


data class VenueResponse(
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("venues")
    val venues: List<Venue>
)
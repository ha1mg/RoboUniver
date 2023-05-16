package com.halmg.robouniver.model.api

import kotlinx.serialization.Serializable

@Serializable
data class VenueResponse(
    val statusCode: Int,
    val venues: List<Venue>
)
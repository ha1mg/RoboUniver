package com.halmg.robouniver.model.api

import kotlinx.serialization.Serializable

@Serializable
data class SigninResponse(
    var statusCode: Int,
    var token: String,
    var name: String
)
package com.halmg.robouniver.data.api

import kotlinx.serialization.Serializable

@Serializable
data class SigninResponse(
    val statusCode: Int,
    val token: String,
    val name: String
)
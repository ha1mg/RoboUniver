package com.halmg.robouniver.model.api

import kotlinx.serialization.Serializable


@Serializable
data class SecretResponse(
    val statusCode: Int,
    val id: Int
)
package com.halmg.robouniver.data.api

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(
    val login: String,
    val password: String,
)


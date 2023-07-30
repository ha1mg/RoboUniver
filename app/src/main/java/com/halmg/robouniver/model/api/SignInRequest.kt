package com.halmg.robouniver.model.api

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(
    val login: String,
    val password: String,
)


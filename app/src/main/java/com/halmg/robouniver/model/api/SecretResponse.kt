package com.halmg.robouniver.model.api

import com.google.gson.annotations.SerializedName

data class SecretResponse(
    @SerializedName("statusCode")
    var statusCode: Int,
    @SerializedName("id")
    var id: Int
)
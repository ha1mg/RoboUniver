package com.halmg.robouniver.data.api

import com.google.gson.annotations.SerializedName

data class Venue (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("discription")
    val discription: String,
    @SerializedName("address")
    val address: String
)
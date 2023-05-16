package com.halmg.robouniver.model.api

import retrofit2.Call
import retrofit2.http.*


interface ApiController {
    @POST("signin")
    fun signin(@Body request: SignInRequest): Call<SigninResponse>

    @GET("secret")
    fun secret(@Header("Authorization") token:String): Call<SecretResponse>

    @GET("venue")
    fun getVenues(): Call<VenueResponse>
}
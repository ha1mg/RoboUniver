package com.halmg.robouniver.model.api

import retrofit2.Call
import retrofit2.http.*


interface ApiController {
    @POST("signin")
    fun signin(@Body request: SignInRequest): Call<SigninResponse>

    @GET("venue")
    fun getVenues(): Call<VenueResponse>
}
package com.halmg.robouniver.data.api

import retrofit2.Call
import retrofit2.http.*


interface ApiController {
    @POST("signin")
    fun signin(@Body request: SignInRequest): Call<SigninResponse>

    @GET("venues")
    fun getVenues(): Call<VenueResponse>
}
package com.halmg.robouniver.model.api

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var authController: ApiController

    fun getAuthController(): ApiController {

        // Initialize ApiService if not initialized yet
        if (!::authController.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.102:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            authController = retrofit.create(ApiController::class.java)
        }

        return authController
    }

    private fun okhttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(context))
            .build()
    }

}
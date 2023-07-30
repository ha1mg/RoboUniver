package com.halmg.robouniver.model.api

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var apiController: ApiController

    fun getApiService(context: Context): ApiController {

        // Initialize ApiService if not initialized yet
        if (!::apiController.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.104:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient(context))
                .build()

            apiController = retrofit.create(ApiController::class.java)
        }

        return apiController
    }

    private fun okhttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(context))
            .build()
    }

}
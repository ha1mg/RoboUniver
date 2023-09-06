package com.halmg.robouniver.ui.home.venue

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.halmg.robouniver.data.api.ApiClient
import com.halmg.robouniver.data.api.Venue
import com.halmg.robouniver.data.api.VenueResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VenueViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private var apiClient = ApiClient()
    val venuesData = MutableLiveData<List<Venue>>()
    fun getVenues() {
        apiClient.getApiService(context).getVenues()
            .enqueue(object : Callback<VenueResponse> {
                override fun onResponse(
                    call: Call<VenueResponse>,
                    response: Response<VenueResponse>
                ) {
                    val venueResponse = response.body()
                    if (venueResponse?.statusCode == 200) {
                        venuesData.postValue(venueResponse.venues)
                    } else {
                        Log.d("Retrofit", "error in get venues")
                    }
                }
                override fun onFailure(call: Call<VenueResponse>, t: Throwable) {
                    Log.d("Retrofit", t.toString())
                }
            })
    }

}
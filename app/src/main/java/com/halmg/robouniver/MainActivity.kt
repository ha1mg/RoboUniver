package com.halmg.robouniver

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.halmg.robouniver.databinding.ActivityMainBinding
import com.halmg.robouniver.model.api.ApiClient
import com.halmg.robouniver.model.api.SessionManager
import com.halmg.robouniver.model.api.Venue
import com.halmg.robouniver.model.api.VenueResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiClient = ApiClient()

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                    R.id.navigation_home, R.id.navigation_journal, R.id.navigation_homework, R.id.navigation_report
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

     fun getVenues(): List<Venue>  {
        lateinit var list: List<Venue>
        apiClient.getApiService(this).getVenues()
            .enqueue(object : Callback<VenueResponse> {
                override fun onFailure(call: Call<VenueResponse>, t: Throwable) {
                    // Error fetching posts
                }

                override fun onResponse(
                    call: Call<VenueResponse>,
                    response: Response<VenueResponse>) {
                        val venueResponse = response.body()
                        if (venueResponse?.statusCode == 200) {
                            list = venueResponse.venues
                        }
                }
            })
        return list
    }
}
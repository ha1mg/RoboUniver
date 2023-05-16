package com.halmg.robouniver.ui.home

import com.halmg.robouniver.model.api.Venue

interface VenueController {
    fun getgetVenues(): List<Venue>
}
package com.halmg.robouniver.ui.home.venue

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.halmg.robouniver.R

class VenueFragment : Fragment() {

    companion object {
        fun newInstance() = VenueFragment()
    }

    private lateinit var viewModel: VenueViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_venue, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VenueViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
package com.halmg.robouniver.ui.home.venue

import android.R
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.lifecycle.Observer
import com.halmg.robouniver.databinding.FragmentVenueBinding



class VenueFragment : Fragment() {

    private var _binding: FragmentVenueBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val venueViewModel = ViewModelProvider(this)[VenueViewModel::class.java]
        _binding = FragmentVenueBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val discriptionView: TextView = binding.venueDiscription
        val addressView: TextView = binding.address



        venueViewModel.getVenues()
        venueViewModel.venuesData.observe(viewLifecycleOwner, Observer { data ->
            val venueNames: List<String> = data.map{ it.name }
            val spinner: Spinner = binding.spinner
            val adapter = ArrayAdapter(requireContext(),
                R.layout.simple_spinner_item, venueNames)
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    addressView.text = data.get(position).address
                    discriptionView.text = data.get(position).discription
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        })

        binding.address.setOnClickListener {
//            val address =
            val geoUriString = "geo:0,0?q=москва+театр+кошек&z=8"
            val geoUri: Uri = Uri.parse(geoUriString)
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            startActivity(mapIntent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
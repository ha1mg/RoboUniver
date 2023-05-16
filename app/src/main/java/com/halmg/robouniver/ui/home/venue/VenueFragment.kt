package com.halmg.robouniver.ui.home.venue

import android.R
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
import com.halmg.robouniver.MainActivity
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

        val listVenues = (activity as MainActivity).getVenues()
        val editList: List<String> = listVenues.map{ it.name }

        val venueHeader: TextView = binding.venueHeader
        val venueDiscription: TextView = binding.venueDiscription
        val spinner: Spinner = binding.spinner
        if (spinner != null) {
            val adapter = ArrayAdapter(requireContext(),
                R.layout.simple_spinner_item, editList)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    venueHeader.text = listVenues[position].name
                    venueDiscription.text = listVenues[position].address
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        }
//        val textView: TextView = binding.textDashboard
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
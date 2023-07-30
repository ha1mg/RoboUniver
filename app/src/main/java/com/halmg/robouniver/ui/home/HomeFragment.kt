package com.halmg.robouniver.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import com.halmg.robouniver.R
import com.halmg.robouniver.databinding.FragmentHomeBinding
import com.halmg.robouniver.model.api.SessionManager

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,

    ): View {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val sessionManager = SessionManager(requireContext())
        val headerV: TextView = binding.headerHome
        headerV.text = sessionManager.fetchTeacherName()

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

//        val layoutShedule: LinearLayout = binding.layoutShedule
//        layoutShedule.setOnClickListener { v ->
//            v.findNavController().navigate(R.id.action_navigation_home_to_sheduleFragment)
//        }

        val layoutManual: LinearLayout = binding.layoutManual
        layoutManual.setOnClickListener { v ->
            v.findNavController().navigate(R.id.action_navigation_home_to_manualFragment)
        }

        val layoutVenue: LinearLayout = binding.layoutVenue
        layoutVenue.setOnClickListener { v ->
            v.findNavController().navigate(R.id.action_navigation_home_to_venueFragment)
        }

        val layoutWages: LinearLayout = binding.layoutWages
        layoutWages.setOnClickListener { v ->
            v.findNavController().navigate(R.id.action_navigation_home_to_wagesFragment)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
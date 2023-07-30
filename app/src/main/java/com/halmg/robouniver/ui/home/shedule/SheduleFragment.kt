package com.halmg.robouniver.ui.home.shedule

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.halmg.robouniver.R
import com.halmg.robouniver.databinding.FragmentHomeBinding
import com.halmg.robouniver.databinding.FragmentSheduleBinding
import com.halmg.robouniver.ui.home.shedule.SheduleViewModel

class SheduleFragment : Fragment() {

    private var _binding: FragmentSheduleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val sheduleViewModel = ViewModelProvider(this)[SheduleViewModel::class.java]

        _binding = FragmentSheduleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        sheduleViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
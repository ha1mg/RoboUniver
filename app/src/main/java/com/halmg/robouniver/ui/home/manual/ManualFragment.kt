package com.halmg.robouniver.ui.home.manual

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.halmg.robouniver.databinding.FragmentManualBinding

class ManualFragment : Fragment() {

    private var _binding: FragmentManualBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val manualViewModel =
            ViewModelProvider(this)[ManualViewModel::class.java]

        _binding = FragmentManualBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textManual
        manualViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
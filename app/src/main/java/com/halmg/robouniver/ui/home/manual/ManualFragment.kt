package com.halmg.robouniver.ui.home.manual

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.halmg.robouniver.R
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
        val manualViewModel = ViewModelProvider(this)[ManualViewModel::class.java]

        _binding = FragmentManualBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val level = resources.getStringArray(R.array.level)
        val manual = resources.getStringArray(R.array.manual_discription)

        val spinner = binding.spinner

        val adapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_spinner_item, level)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                binding.manualDiscription.text = manual.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
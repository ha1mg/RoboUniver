package com.halmg.robouniver.ui.home.wages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.halmg.robouniver.R
import com.halmg.robouniver.databinding.FragmentJournalBinding
import com.halmg.robouniver.databinding.FragmentWagesBinding
import com.halmg.robouniver.ui.journal.JournalViewModel

class WagesFragment : Fragment() {

    private var _binding: FragmentWagesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val journalViewModel =
            ViewModelProvider(this).get(WagesViewModel::class.java)

        _binding = FragmentWagesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        journalViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
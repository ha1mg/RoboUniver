package com.halmg.robouniver.ui.journal

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.halmg.robouniver.databinding.FragmentJournalBinding

class JournalFragment : Fragment() {

    private var _binding: FragmentJournalBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val journalViewModel =
            ViewModelProvider(this).get(JournalViewModel::class.java)

        _binding = FragmentJournalBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textJournal
//        journalViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        recyclerView = binding.recyclerJournal
//        recyclerView.layoutManager = LinearLayoutManager(this)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
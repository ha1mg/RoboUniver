package com.halmg.robouniver.ui.home.wages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.halmg.robouniver.R

class WagesFragment : Fragment() {

    companion object {
        fun newInstance() = WagesFragment()
    }

    private lateinit var viewModel: WagesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wages, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WagesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
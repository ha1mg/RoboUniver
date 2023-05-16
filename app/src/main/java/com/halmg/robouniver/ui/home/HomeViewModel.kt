package com.halmg.robouniver.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.internal.ContextUtils.getActivity
import com.halmg.robouniver.model.api.SessionManager

class HomeViewModel : ViewModel() {

    private val _header = MutableLiveData<String>().apply {

    }
    private val _text = MutableLiveData<String>().apply {
        value = "Преподаватель робототехники и программирования"
    }
    val header: LiveData<String> = _header
    val text: LiveData<String> = _text
}
package com.halmg.robouniver.ui.home.shedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SheduleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is shedule Fragment"
    }
    val text: LiveData<String> = _text
}
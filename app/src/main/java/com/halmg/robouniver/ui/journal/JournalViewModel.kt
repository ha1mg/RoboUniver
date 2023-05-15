package com.halmg.robouniver.ui.journal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class JournalViewModel : ViewModel() {
    var studentsTable: DatabaseReference = Firebase.database.reference
    private val _text = MutableLiveData<String>().apply {
        value = "This is journal Fragment"
    }
    val text: LiveData<String> = _text
}
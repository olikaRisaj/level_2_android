package com.example.homeworksecond

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactViewModel: ViewModel() {
    val contactsLiveData = MutableLiveData<List<Contactdata>>()

    fun getHardCodeContacts() {
        contactsLiveData.value = emptyList()
    }


}
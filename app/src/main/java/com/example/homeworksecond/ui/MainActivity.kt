package com.example.homeworksecond.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworksecond.ContactViewModel
import com.example.homeworksecond.Contactdata
import com.example.homeworksecond.ContactsDataList
import com.example.homeworksecond.RvAdapter
import com.example.homeworksecond.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactList: List<Contactdata>
    lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contactViewModel = ContactViewModel()

        contactViewModel.contactsLiveData.observe(this) {
            (binding.rvList.adapter as RvAdapter).updateData()
        }
        contactList = ContactsDataList.getContacts()
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RvAdapter(contactList)
        }
    }
}


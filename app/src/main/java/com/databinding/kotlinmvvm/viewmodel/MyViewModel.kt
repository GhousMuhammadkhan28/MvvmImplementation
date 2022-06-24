package com.databinding.kotlinmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.databinding.kotlinmvvm.model.Contacts
import com.databinding.kotlinmvvm.model.Resource
import com.databinding.kotlinmvvm.repository.MyRepo

class MyViewModel : ViewModel() {

    var myRepo: MyRepo? = null

    init {
        myRepo = MyRepo()
    }

    fun getContact(): MutableLiveData<Resource<ArrayList<Contacts>>> {
        lateinit var listingContact: MutableLiveData<Resource<ArrayList<Contacts>>>
        listingContact = myRepo?.getContacts() ?: MutableLiveData<Resource<ArrayList<Contacts>>>()
        return listingContact
    }

}
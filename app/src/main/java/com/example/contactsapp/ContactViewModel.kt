package com.example.contactsapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    private val contactDao = ContactDatabase.getDatabase(application).contactDao()

    val allContacts = contactDao.getAllContacts()

    fun addContact(contact: Contact) {
        viewModelScope.launch {
            contactDao.insertContact(contact)
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            contactDao.deleteContact(contact)
        }
    }
}

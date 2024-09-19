package com.example.contactsapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): Flow<List<Contact>>

    @Delete
    suspend fun deleteContact(contact: Contact)
}

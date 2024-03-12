package uz.gita.contactappcompose.domain

import kotlinx.coroutines.flow.Flow
import uz.gita.contactappcompose.data.model.ContactUIData
import uz.gita.contactappcompose.data.model.remote.request.AddContactRequest
import uz.gita.contactappcompose.data.model.remote.response.AddContactResponse

interface ContactRepository {
    fun loadContacts(): Flow<Result<List<ContactUIData>>>
    fun addContact(data : AddContactRequest): Flow<Result<AddContactResponse>>
}
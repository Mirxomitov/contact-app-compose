package uz.gita.contactappcompose.domain

import uz.gita.contactappcompose.data.model.ContactUIData
import kotlinx.coroutines.flow.Flow
interface ContactRepository {
    fun loadContacts() : Flow<Result<List<ContactUIData>>>
}
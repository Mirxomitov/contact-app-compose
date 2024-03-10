package uz.gita.contactappcompose.domain.impls

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.contactappcompose.data.model.ContactUIData
import uz.gita.contactappcompose.data.source.local.SharedPreference
import uz.gita.contactappcompose.data.source.remote.api.ContactApi
import uz.gita.contactappcompose.domain.ContactRepository
import uz.gita.contactappcompose.utils.mapper.toUIData
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val sharedPreference: SharedPreference,
    private val api: ContactApi
) : ContactRepository {
    override fun loadContacts(): Flow<Result<List<ContactUIData>>> = flow {
        val response = api.allContacts(sharedPreference.getToken())
        if (response.isSuccessful && response.body() != null) {
            emit(Result.success(response.body()!!.map { it.toUIData() }))
        } else {
            emit(Result.failure(Exception("All Contact Error")))
        }
    }.catch { emit(Result.failure(Exception("Unknown exception"))) }
        .flowOn(Dispatchers.IO)
}
package uz.gita.contactappcompose.domain

import kotlinx.coroutines.flow.Flow
import uz.gita.contactappcompose.data.model.StartScreenEnum
import uz.gita.contactappcompose.data.model.remote.request.LogInRequestData
import uz.gita.contactappcompose.data.model.remote.response.LogInResponseData

interface IdentificationRepository {
    fun startScreen(): StartScreenEnum
    fun login(data: LogInRequestData): Flow<Result<LogInResponseData>>
    fun saveToken(token : String)
}
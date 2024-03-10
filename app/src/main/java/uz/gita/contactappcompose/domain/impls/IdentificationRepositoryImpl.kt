package uz.gita.contactappcompose.domain.impls

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.contactappcompose.data.model.StartScreenEnum
import uz.gita.contactappcompose.data.model.remote.request.LogInRequestData
import uz.gita.contactappcompose.data.model.remote.response.LogInResponseData
import uz.gita.contactappcompose.data.source.local.SharedPreference
import uz.gita.contactappcompose.data.source.remote.api.ContactApi
import uz.gita.contactappcompose.domain.IdentificationRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class IdentificationRepositoryImpl @Inject constructor(
    private val sharedPreference: SharedPreference,
    private val api: ContactApi
) : IdentificationRepository {
    override fun startScreen(): StartScreenEnum {
        return when (sharedPreference.getToken()) {
            "LOGIN" -> StartScreenEnum.Login
            else -> StartScreenEnum.Main
        }
    }

    override fun login(data: LogInRequestData): Flow<Result<LogInResponseData>> =
        flow {
            val response = api.logIn(data)
            if (response.isSuccessful && response.body() != null) {
                emit(Result.success(response.body()!!))
            } else emit(Result.failure(Exception("Unknown exception failure")))
        }
            .flowOn(Dispatchers.IO)
            .catch { emit(Result.failure(Exception("Unknown exception try catch"))) }
    override fun saveToken(token: String) {
        sharedPreference.saveToken(token)
    }
}
package uz.gita.contactappcompose.data.source.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.contactappcompose.data.model.remote.request.LogInRequestData
import uz.gita.contactappcompose.data.model.remote.request.RegisterRequestData
import uz.gita.contactappcompose.data.model.remote.request.VerifyRequestData
import uz.gita.contactappcompose.data.model.remote.response.LogInResponseData
import uz.gita.contactappcompose.data.model.remote.response.RegisterResponseData
import uz.gita.contactappcompose.data.model.remote.response.VerifyResponseData

interface ContactApi {

    @POST("api/v1/register/")
    suspend fun registerUser(
        @Body data: RegisterRequestData
    ): Response<RegisterResponseData>

    @POST
    suspend fun verifySmsCode(
        @Body data: VerifyRequestData
    ): Response<VerifyResponseData>

    @POST
    suspend fun logIn(
        @Body data: LogInRequestData
    ): Response<LogInResponseData>
}
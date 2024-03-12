package uz.gita.contactappcompose.data.source.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import uz.gita.contactappcompose.data.model.remote.request.AddContactRequest
import uz.gita.contactappcompose.data.model.remote.request.LogInRequestData
import uz.gita.contactappcompose.data.model.remote.request.RegisterRequestData
import uz.gita.contactappcompose.data.model.remote.request.VerifyRequestData
import uz.gita.contactappcompose.data.model.remote.response.AddContactResponse
import uz.gita.contactappcompose.data.model.remote.response.ContactResponse
import uz.gita.contactappcompose.data.model.remote.response.LogInResponseData
import uz.gita.contactappcompose.data.model.remote.response.RegisterResponseData
import uz.gita.contactappcompose.data.model.remote.response.VerifyResponseData

interface ContactApi {

    @POST("api/v1/register")
    suspend fun registerUser(
        @Body data: RegisterRequestData
    ): Response<RegisterResponseData>

    @POST("api/v1/register/verify")
    suspend fun verifySmsCode(
        @Body data: VerifyRequestData
    ): Response<VerifyResponseData>

    @POST("api/v1/login")
    suspend fun logIn(
        @Body data: LogInRequestData
    ): Response<LogInResponseData>

    @GET("api/v1/contact")
    suspend fun allContacts(@Header("token") token: String): Response<List<ContactResponse>>

    @POST("api/v1/contact")
    suspend fun addContact(
        @Header("token") token: String,
        @Body data: AddContactRequest
    ): Response<AddContactResponse>
}
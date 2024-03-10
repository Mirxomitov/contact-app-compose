package uz.gita.contactappcompose.data.model.remote.request

data class VerifyRequestData(
    val phone : String,
    val code : String,
)
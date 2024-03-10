package uz.gita.contactappcompose.data.model.remote.request

data class RegisterRequestData(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val password: String,
)
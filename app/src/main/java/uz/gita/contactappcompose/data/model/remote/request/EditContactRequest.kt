package uz.gita.contactappcompose.data.model.remote.request

data class EditContactRequest(
    val id : String,
    val firstName: String,
    val lastName: String,
    val phone: String,
)
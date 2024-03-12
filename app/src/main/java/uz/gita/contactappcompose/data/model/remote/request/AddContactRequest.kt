package uz.gita.contactappcompose.data.model.remote.request

data class AddContactRequest(
    val firstName: String,
    val lastName: String,
    val phone: String,
)
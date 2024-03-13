package uz.gita.contactappcompose.utils.mapper

import uz.gita.contactappcompose.data.model.ContactUIData
import uz.gita.contactappcompose.data.model.remote.request.EditContactRequest
import uz.gita.contactappcompose.data.model.remote.response.ContactResponse
import uz.gita.contactappcompose.utils.logger

fun ContactResponse.toUIData(): ContactUIData {
    logger("ContactResponse.toUIData -> " + this.id)
    return ContactUIData(
        id = this.id.toInt(),
        firstName = this.firstName,
        lastName = this.lastName,
        phoneNumber = this.phone,
    )
}

fun ContactUIData.toEditContactRequest(): EditContactRequest {
    return EditContactRequest(
        id = this.id.toString(),
        firstName = this.firstName,
        lastName = this.lastName,
        phone = this.phoneNumber
    )
}
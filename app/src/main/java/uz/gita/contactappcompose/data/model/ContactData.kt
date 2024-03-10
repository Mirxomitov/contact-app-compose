package uz.gita.contactappcompose.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContactUIData(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
) : Parcelable

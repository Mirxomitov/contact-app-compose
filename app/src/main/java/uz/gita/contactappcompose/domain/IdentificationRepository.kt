package uz.gita.contactappcompose.domain

import uz.gita.contactappcompose.data.model.StartScreenEnum

interface IdentificationRepository {
    fun startScreen() : StartScreenEnum
}
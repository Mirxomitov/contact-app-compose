package uz.gita.contactappcompose.domain.impls

import uz.gita.contactappcompose.data.model.StartScreenEnum
import uz.gita.contactappcompose.data.source.local.SharedPreference
import uz.gita.contactappcompose.domain.IdentificationRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class IdentificationRepositoryImpl @Inject constructor(
    private val sharedPreference: SharedPreference
) : IdentificationRepository {
    override fun startScreen(): StartScreenEnum {
        return when (sharedPreference.getToken()) {
            "LOGIN" -> StartScreenEnum.Login
            else -> StartScreenEnum.Main
        }
    }
}
package uz.gita.contactappcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.contactappcompose.domain.ContactRepository
import uz.gita.contactappcompose.domain.IdentificationRepository
import uz.gita.contactappcompose.domain.impls.ContactRepositoryImpl
import uz.gita.contactappcompose.domain.impls.IdentificationRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun getIdentificationRepository(impl: IdentificationRepositoryImpl): IdentificationRepository

    @Binds
    fun getContactRepository(impl: ContactRepositoryImpl): ContactRepository
}
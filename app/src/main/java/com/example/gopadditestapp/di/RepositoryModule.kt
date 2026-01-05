package com.example.gopadditestapp.di

import com.example.gopadditestapp.data.repository.GoPaddiTestRepositoryImpl
import com.example.gopadditestapp.domain.repository.GoPaddiTestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindGoPaddiTestRepository(
        goPaddiTestRepositoryImpl: GoPaddiTestRepositoryImpl
    ): GoPaddiTestRepository
}
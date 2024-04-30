package com.akv.animatrix.di

import com.akv.animatrix.data.remote.repository.NekoRepositoryImpl
import com.akv.animatrix.domain.repository.NekoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NekoRepoModule {

    @Binds
    @Singleton
    fun bindNekoRepository(nekoRepositoryImpl: NekoRepositoryImpl): NekoRepository
}
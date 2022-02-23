package com.aptivist.clashapp.core.di

import com.aptivist.clashapp.data.remote.ClashRoyaleAPI
import com.aptivist.clashapp.data.remote.RoyalRepositoryImpl
import com.aptivist.clashapp.domain.repositories.RoyalAPIRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
@Singleton
@Provides
fun providesRoyalAPIRepository(clashAPI:ClashRoyaleAPI): RoyalAPIRepository = RoyalRepositoryImpl(clashAPI)
}
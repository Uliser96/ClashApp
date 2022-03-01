package com.aptivist.clashapp.domain.repositories

import com.aptivist.clashapp.data.remote.models.AllCardsResponse
import com.aptivist.clashapp.data.remote.models.ProfileResponse

interface RoyalAPIRepository {
    suspend fun fetchAllCards():AllCardsResponse
    suspend fun fetchPlayerInfo(tag: String): ProfileResponse
}
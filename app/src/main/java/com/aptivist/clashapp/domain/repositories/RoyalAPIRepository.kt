package com.aptivist.clashapp.domain.repositories

import com.aptivist.clashapp.data.remote.models.AllCardsResponse

interface RoyalAPIRepository {
    suspend fun fetchAllCards():AllCardsResponse
}
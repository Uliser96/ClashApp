package com.aptivist.clashapp.data.remote

import com.aptivist.clashapp.data.remote.models.AllCardsResponse
import com.aptivist.clashapp.domain.repositories.RoyalAPIRepository

class RoyalRepositoryImpl(
    private val royalAPI: ClashRoyaleAPI
): RoyalAPIRepository {
    override suspend fun fetchAllCards(): ArrayList<AllCardsResponse> {
        return royalAPI.getAllCards()
    }
}
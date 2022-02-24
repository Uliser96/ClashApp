package com.aptivist.clashapp.data.remote

import com.aptivist.clashapp.data.remote.models.AllCardsResponse
import retrofit2.http.GET

interface ClashRoyaleAPI {
    @GET("cards")
    suspend fun getAllCards(): ArrayList<AllCardsResponse>
}
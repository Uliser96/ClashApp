package com.aptivist.clashapp.data.remote

import com.aptivist.clashapp.data.remote.models.AllCardsResponse
import com.aptivist.clashapp.data.remote.models.ProfileResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ClashRoyaleAPI {
    @GET("cards")
    suspend fun getAllCards(): AllCardsResponse
    @GET("players/{tag}")
    suspend fun getPlayerInfo(@Path("tag")tag:String): ProfileResponse
}
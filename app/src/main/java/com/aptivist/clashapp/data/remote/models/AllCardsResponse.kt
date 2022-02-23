package com.aptivist.clashapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AllCardsResponse(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("maxLevel") val maxLevel: Int,
    @SerializedName("iconUrls") val iconUrls: IconsUrls
    ): Parcelable

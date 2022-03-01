package com.aptivist.clashapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileResponse(
    @SerializedName("tag") val tag: String,
    @SerializedName("name") val name: String,
    @SerializedName("expLevel") val expLevel: Int,
    @SerializedName("trophies") val trophies: Int,
    @SerializedName("bestTrophies") val bestTrophies: Int,
    @SerializedName("wins") val wins: Int,
    @SerializedName("losses") val losses: Int,
    @SerializedName("battleCount") val battleCount: Int
): Parcelable

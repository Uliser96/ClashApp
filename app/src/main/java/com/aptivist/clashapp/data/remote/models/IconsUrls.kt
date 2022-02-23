package com.aptivist.clashapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IconsUrls(
    @SerializedName("medium") val medium: String
): Parcelable

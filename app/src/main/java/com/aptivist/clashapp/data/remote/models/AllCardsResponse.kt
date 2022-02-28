package com.aptivist.clashapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class AllCardsResponse(
    @SerializedName("items") val items: ArrayList<AllCardsListResponse>
    )

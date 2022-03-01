package com.aptivist.clashapp.presentation.features.allcards

import com.aptivist.clashapp.data.remote.models.AllCardsResponse

sealed class RequestViewState(){
    class Success(val data: AllCardsResponse): RequestViewState()
    class Error(val message: String): RequestViewState()
    class Loading(val isLoading: Boolean) : RequestViewState()
}

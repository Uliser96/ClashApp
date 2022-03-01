package com.aptivist.clashapp.presentation.features.profile

import com.aptivist.clashapp.data.remote.models.ProfileResponse

sealed class ProfileViewState(){
    class Success(val data: ProfileResponse): ProfileViewState()
    class Error(val message: String): ProfileViewState()
    class Loading(val isLoading: Boolean) : ProfileViewState()
}

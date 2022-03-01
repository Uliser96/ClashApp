package com.aptivist.clashapp.presentation.features.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aptivist.clashapp.data.remote.models.ProfileResponse
import com.aptivist.clashapp.domain.repositories.RoyalAPIRepository
import com.aptivist.clashapp.presentation.features.allcards.RequestViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: RoyalAPIRepository
): ViewModel(){
    private var _data = MutableLiveData<ProfileViewState>()
    val data: LiveData<ProfileViewState> get() = _data

    fun getPlayerProfile(tag: String){
        viewModelScope.launch(Dispatchers.IO) {
            //Add here loading state
            _data.postValue(ProfileViewState.Loading(true))
            try {
                //Here we can map to domain if necessary
                val result = repository.fetchPlayerInfo(tag)
                _data.postValue(ProfileViewState.Success(result))
                _data.postValue(ProfileViewState.Loading(false))
            } catch (e: Exception) {
                _data.postValue(ProfileViewState.Loading(false))
                _data.postValue(ProfileViewState.Error(e.message!!))
            }
        }
    }
}
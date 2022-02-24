package com.aptivist.clashapp.presentation.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aptivist.clashapp.data.remote.models.AllCardsResponse
import com.aptivist.clashapp.domain.repositories.RoyalAPIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AllCardsViewModel @Inject constructor(
    private val repository: RoyalAPIRepository
): ViewModel(){
    private var _data = MutableLiveData<ArrayList<AllCardsResponse>>()
    val data : LiveData<ArrayList<AllCardsResponse>> get() = _data

    fun getAllCards(){
        viewModelScope.launch (Dispatchers.IO){
            //Add here loading state
            try{
                val response = repository.fetchAllCards()
                _data.postValue(response)
            }catch (e: Exception){

            }
        }
    }
}
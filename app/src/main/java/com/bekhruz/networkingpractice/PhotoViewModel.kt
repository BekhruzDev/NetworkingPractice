package com.bekhruz.networkingpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bekhruz.networkingpractice.network.*
import kotlinx.coroutines.launch
import java.lang.Exception



class PhotoViewModel: ViewModel() {
    private val _photos = MutableLiveData<Images>()
    val photos:LiveData<Images> = _photos
    private val _networkState = MutableLiveData<NetworkState>()
    val networkState:LiveData<NetworkState> = _networkState

    init {
        getPictures()
    }
    private fun getPictures(){
        viewModelScope.launch{
            _networkState.value = NetworkState.Loading
            try{
                val response = Repositories.getPhotos()
                if (response.isSuccessful) {
                    _networkState.value = NetworkState.Success
                    _photos.value = response.body()
                } else {
                    _networkState.value = NetworkState.HttpError
                }
            }catch (e: Exception){
                _networkState.value = NetworkState.NetworkException
            }
        }
    }


}
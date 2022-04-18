package com.bekhruz.networkingpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bekhruz.networkingpractice.network.Images
import com.bekhruz.networkingpractice.network.PhotosApi
import kotlinx.coroutines.launch

class PhotoViewModel: ViewModel() {
    private val _photos = MutableLiveData<Images>()
    val photos:LiveData<Images> = _photos

    init {
        getPictures()
    }
    private fun getPictures(){
        viewModelScope.launch{
            _photos.value = PhotosApi.retrofitService.getPhotos()
        }
    }
}
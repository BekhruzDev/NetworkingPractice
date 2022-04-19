package com.bekhruz.networkingpractice.network

import com.bekhruz.networkingpractice.Constants
import retrofit2.Response

object Repositories {
   suspend fun getPhotos():Response<Images>{
        return PhotosApi.retrofitService.getPhotos(
            apiKey = Constants.API_KEY,
            searchInput = "nature",
            imageType = "photo",
            pretty = true
        )
    }
}
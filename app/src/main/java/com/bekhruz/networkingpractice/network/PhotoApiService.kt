package com.bekhruz.networkingpractice.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://pixabay.com/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface PhotoApiService{
    //TODO: USE @QUERIES
@GET("?key=26791382-401008e990a0a45ca9b7993ec&q=nature&image_type=photo&pretty=true")
suspend fun getPhotos():Images
}

object PhotosApi{
    val retrofitService:PhotoApiService by lazy {
        retrofit.create(PhotoApiService::class.java)
    }
}
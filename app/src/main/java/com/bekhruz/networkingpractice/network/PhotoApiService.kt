package com.bekhruz.networkingpractice.network

import com.bekhruz.networkingpractice.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//full url: https://pixabay.com/api/?key=26791382-401008e990a0a45ca9b7993ec&q=nature&image_type=photo&pretty=true

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface PhotoApiService{
@GET("/api/")
suspend fun getPhotos(
        @Query("key") apiKey: String,
        @Query("q") searchInput: String,
        @Query("image_type") imageType: String,
        @Query("pretty") pretty: Boolean
): Response<Images>
}

object PhotosApi{
    val retrofitService:PhotoApiService by lazy {
        retrofit.create(PhotoApiService::class.java)
    }
}
package com.bekhruz.networkingpractice.network

import com.squareup.moshi.Json

data class Photo(
    val id: Long,
    @Json(name = "webformatURL") val imageUrl: String,
    val likes: Int,
    val tags: String
)
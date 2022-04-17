package com.bekhruz.networkingpractice.network

import com.squareup.moshi.Json

data class Images(
    @Json(name = "hits") val photosList: List<Photo>
)
package com.bekhruz.networkingpractice.adapter

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bekhruz.networkingpractice.network.Hit

@BindingAdapter("loadImage")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri)
    }
}

@BindingAdapter("adapterData")
fun bindRecyclerview(recyclerView: RecyclerView, dataList: List<Hit>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(dataList)
}
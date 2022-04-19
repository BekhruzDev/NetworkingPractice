package com.bekhruz.networkingpractice.adapter

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bekhruz.networkingpractice.R
import com.bekhruz.networkingpractice.network.Hit
import com.bekhruz.networkingpractice.network.NetworkState
import com.bekhruz.networkingpractice.network.NetworkState.*
@BindingAdapter("loadImage")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri){
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("networkData", "networkStatus", requireAll = true)
fun bindRecyclerview(recyclerView: RecyclerView, dataList: List<Hit>?, networkState: NetworkState?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(dataList)
    when(networkState){
         Success -> {
            recyclerView.visibility  = View.VISIBLE
        }
        else -> {
            recyclerView.visibility = View.GONE
        }
    }
}


@BindingAdapter("networkState")
fun bindStatus(statusImgView: ImageView, networkState: NetworkState?){
    when(networkState) {
        Loading -> {
            statusImgView.visibility = View.VISIBLE
           statusImgView.setImageResource(R.drawable.loading_animation)
        }
        Success ->{
            statusImgView.visibility = View.GONE
        }
        else ->{
            statusImgView.visibility = View.VISIBLE
            statusImgView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

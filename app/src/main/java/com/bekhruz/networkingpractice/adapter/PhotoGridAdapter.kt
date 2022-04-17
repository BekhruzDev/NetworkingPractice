package com.bekhruz.networkingpractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bekhruz.networkingpractice.databinding.ItemLayoutBinding
import com.bekhruz.networkingpractice.network.Photo

class PhotoGridAdapter : ListAdapter<Photo, PhotoGridAdapter.PhotoViewHolder>(DiffCallBack) {

    class PhotoViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //here we need to initialize the binding expression 'photo'
        //with the element from list of photos
        fun bind(photoElement: Photo) {
            binding.photo = photoElement
            //execute the update immediately
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val elementOfPhotos = getItem(position)
        holder.bind(elementOfPhotos)
    }

    companion object DiffCallBack:DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
        }

    }
}



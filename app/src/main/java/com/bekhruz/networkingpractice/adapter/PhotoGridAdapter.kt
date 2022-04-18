package com.bekhruz.networkingpractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bekhruz.networkingpractice.databinding.ItemLayoutBinding
import com.bekhruz.networkingpractice.network.Hit

class PhotoGridAdapter : ListAdapter<Hit, PhotoGridAdapter.PhotoViewHolder>(DiffCallBack) {

    class PhotoViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //here we need to initialize the binding expression 'photo'
        //with the element from list of photos
        fun bind(photoElement: Hit) {
            binding.hit = photoElement
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

    companion object DiffCallBack:DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.webformatURL == newItem.webformatURL
        }

    }
}



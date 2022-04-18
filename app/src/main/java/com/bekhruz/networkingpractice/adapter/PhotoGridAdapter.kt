package com.bekhruz.networkingpractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bekhruz.networkingpractice.R
import com.bekhruz.networkingpractice.databinding.ItemLayoutBinding
import com.bekhruz.networkingpractice.network.Hit
import com.bumptech.glide.Glide

class PhotoGridAdapter : ListAdapter<Hit, PhotoGridAdapter.PhotoViewHolder>(DiffCallBack) {

    class PhotoViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photoElement: Hit) {
            Glide.with(itemView.context).load(photoElement.webformatURL).into(binding.itemImageview)
            binding.likesTextview.text =
                itemView.context.getString(R.string.number_of_likes, photoElement.likes)
            binding.imageTagsTextview.text = photoElement.tags
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

    companion object DiffCallBack : DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.webformatURL == newItem.webformatURL
        }

    }
}



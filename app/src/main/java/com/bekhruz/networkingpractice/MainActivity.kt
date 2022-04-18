package com.bekhruz.networkingpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bekhruz.networkingpractice.adapter.PhotoGridAdapter
import com.bekhruz.networkingpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: PhotoViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : PhotoGridAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = PhotoGridAdapter()
        binding.photosRecyclerview.adapter = adapter
        binding.photosRecyclerview.setHasFixedSize(true)
        viewModel.photos.observe(this, Observer {
            Log.d("ResponseInObserver", it.toString())
            adapter.submitList(it.hits)
        })

    }
}
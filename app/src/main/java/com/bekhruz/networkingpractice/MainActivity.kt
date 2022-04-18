package com.bekhruz.networkingpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bekhruz.networkingpractice.adapter.PhotoGridAdapter
import com.bekhruz.networkingpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: PhotoViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        recyclerView = binding.photosRecyclerview
        recyclerView.adapter = PhotoGridAdapter()
        recyclerView.setHasFixedSize(true)
    }
}
package com.example.retrofit.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.R
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.retrofit.data.modelserver.Item
import com.example.retrofit.databinding.ActivityMainBinding

class ItemActivity : AppCompatActivity() {
    private val itemViewModel by viewModels<ItemViewModel>()
    private var itemAdapter = ItemAdapter()
    private var handler = android.os.Handler()
    private val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val itemObserver = Observer<MutableList<Item>> {
            it?.let { list ->
                binding.view.visibility = View.VISIBLE
                handler.postDelayed(Runnable {
                    binding.view.visibility = View.GONE
                    itemAdapter.itemList = list

                }, 1000)
            }
        }
        itemViewModel.currentItemsLiveData.observe(this, itemObserver)
    }
}
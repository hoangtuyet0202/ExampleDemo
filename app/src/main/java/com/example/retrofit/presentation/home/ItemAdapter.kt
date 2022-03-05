package com.example.retrofit.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.data.modelserver.Item
import com.example.retrofit.databinding.ItemDataBinding

class ItemAdapter :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    var itemList: MutableList<Item> = mutableListOf()
        set(value) {
            field = value
        }
    class ItemViewHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemDataBinding>(
            layoutInflater,
            R.layout.item_data,
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holderFood: ItemAdapter.ItemViewHolder, position: Int) {
        val item = itemList[position]
        holderFood.binding.item = item
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}
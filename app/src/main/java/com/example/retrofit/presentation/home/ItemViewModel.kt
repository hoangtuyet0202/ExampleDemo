package com.example.retrofit.presentation.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.data.modelserver.Item
import com.example.retrofit.data.repository.ItemRepository

class ItemViewModel: ViewModel() {
    private val itemRepository = ItemRepository()
    val itemLiveData = MutableLiveData<MutableList<Item>>()
    val currentItemsLiveData = MutableLiveData<MutableList<Item>>()

    fun getItems() {
        val temp = mutableListOf<Item>()
        itemRepository.getData(onSuccess = {
            itemLiveData.value = it
            it.forEachIndexed { index, item ->
                if (index < 7) {
                    temp.add(item)
                    Log.d("AAA", "getItems: $index")
                }
            }
            currentItemsLiveData.value = temp.toMutableList()
        }, onError = {
            Log.d("AAA", "getFoods: ${it}")
        })
    }
}
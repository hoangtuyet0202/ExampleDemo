package com.example.retrofit.data.repository

import com.example.retrofit.data.modelserver.DataResponse
import com.example.retrofit.data.modelserver.Item
import com.example.retrofit.utils.ItemUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemRepository {
    private val itemService = ItemUtils.getItemService()
    fun getData(
        onSuccess:(datas: MutableList<Item>)-> Unit,
        onError: (t: Throwable?)-> Unit
    ) {
        itemService.getAllDatas().enqueue(object : Callback<DataResponse> {
            override fun onResponse(
                call: Call<DataResponse>,
                response: Response<DataResponse>
            ) {
                if(response.isSuccessful) {
                    onSuccess.invoke(response.body()?.data!!)
                } else {
                    onError.invoke(null)
                }
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                onError.invoke(t)
            }

        })
    }
}
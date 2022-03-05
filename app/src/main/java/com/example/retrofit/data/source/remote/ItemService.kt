package com.example.retrofit.data.source.remote

import com.example.retrofit.data.modelserver.DataResponse
import retrofit2.Call
import retrofit2.http.GET

interface ItemService {
    @GET("/unknown")
    fun getAllDatas() : Call<DataResponse>
}
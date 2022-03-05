package com.example.retrofit.utils

import com.example.retrofit.data.source.remote.ItemService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItemUtils {
    companion object {
        private const val BASE_URL = "https://reqres.in/api/"

        private var retrofit: Retrofit? = null
        private fun getClient(baseUrl: String?): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }

        fun getItemService(): ItemService {
            return getClient(BASE_URL)?.create(ItemService::class.java)!!
        }
    }
}
package com.example.retrofit.data.modelserver

import com.google.gson.annotations.SerializedName

class DataResponse {
    @SerializedName("page")
    var page: Int? = null

    @SerializedName("per_page")
    var perPage: Int? = null

    @SerializedName("total")
    var total: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

    @SerializedName("data")
    var data: MutableList<Item>? = null
}
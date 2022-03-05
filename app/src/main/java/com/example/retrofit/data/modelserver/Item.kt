package com.example.retrofit.data.modelserver

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("year")
    @Expose
    var year: Int? = null

    @SerializedName("pantone_value")
    @Expose
    var pantoneValue: String? = null
}
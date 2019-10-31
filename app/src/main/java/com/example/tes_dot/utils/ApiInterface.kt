package com.example.tes_dot.utils

import com.example.tes_dot.models.ModelData
import com.example.tes_dot.models.ModelJSON
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("ListData.json")
    fun getData(): Call<ModelJSON>
}
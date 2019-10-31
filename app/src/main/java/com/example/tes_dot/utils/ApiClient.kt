package com.example.tes_dot.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    var retrofit: Retrofit? = null

    companion object {
        val BASE_URL: String =
            "https://gist.githubusercontent.com/yoesuv/0c274f3314cefd40f66e6ed83f08acc6/raw/8b0c6eb6a95cde6db904f5a0eddba280aef96680/"
        val IMAGE_URL: String = "$BASE_URL/media/"
        val API_URL = "$BASE_URL/"
    }

    fun getClient(): Retrofit {

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

}
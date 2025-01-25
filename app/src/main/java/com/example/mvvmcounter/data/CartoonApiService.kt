package com.example.mvvmcounter.data

import com.example.mvvmcounter.data.model.BaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface CartoonApiService {

    @GET("character")
    fun getCharacters(): Call<BaseResponse>

}
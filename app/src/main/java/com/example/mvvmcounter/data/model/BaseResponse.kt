package com.example.mvvmcounter.data.model


import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("info")
    val info: Info? = null,
    @SerializedName("results")
    val characters: List<Character>? = null
)
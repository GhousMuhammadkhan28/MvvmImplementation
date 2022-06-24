package com.databinding.kotlinmvvm.network

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/contacts/")
    fun getContact(): Call<JsonElement>
}
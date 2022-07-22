package com.kyared.listapersonas.model

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/")
    fun getPersons(): Call<JsonObject>
}
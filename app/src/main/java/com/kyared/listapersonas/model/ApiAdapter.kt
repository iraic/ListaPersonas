package com.kyared.listapersonas.model

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiAdapter {
    val urlApi = "https://randomuser.me/"

    fun getClientService(): ApiService {
        val authInterceptor = Interceptor { chain ->
            val url = chain.request().url().newBuilder()
                .addQueryParameter("results", "50")
                //.addQueryParameter("callback", "randomuserdata")
                .build()

            val newRequest = chain.request()
                .newBuilder()
                .url(url)
                .build()

            chain.proceed(newRequest)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(urlApi)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return  retrofit.create(ApiService::class.java)
    }
}
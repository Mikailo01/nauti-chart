package com.bytecause.nautichart.data.remote.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class OverpassRestApiBuilder {

    // Create an OkHttpClient builder
    private val httpClientBuilder = OkHttpClient.Builder().apply {
        readTimeout(120, TimeUnit.SECONDS)
        writeTimeout(120, TimeUnit.SECONDS)
    }

    // Create the OkHttpClient
    private val okHttpClient = httpClientBuilder.build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://overpass-api.de/api/")
        .build()

    fun overpassSearch(): OverpassRestApiService {
        return retrofit.create(OverpassRestApiService::class.java)
    }
}
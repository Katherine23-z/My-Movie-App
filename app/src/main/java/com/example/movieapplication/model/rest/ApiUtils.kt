package com.example.movieapplication.model.rest

import okhttp3.OkHttpClient

object ApiUtils {
    private val baseUrlMainPart = "https://api.themoviedb.org/"
    private val baseUrlVersion = "3/"
    val baseUrl = "$baseUrlMainPart$baseUrlVersion"

    fun getOkHTTPBuilderWithHeaders(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("api_key", "60898dfa429c5c8d1deb207e46423f7e")
                .method(original.method(), original.body())
                .build()

            chain.proceed(request)
        }
        return httpClient.build()
    }
}
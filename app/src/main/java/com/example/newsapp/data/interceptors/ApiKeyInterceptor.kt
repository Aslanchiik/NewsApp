package com.example.newsapp.data.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("AutoGenerator", "apiKey=e0f37cd53f044659a4911ed116efb54f")
            .build()
        return chain.proceed(request)
    }
}
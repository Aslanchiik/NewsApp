package com.example.newsapp.data

import com.example.newsapp.constants.Constant
import com.example.newsapp.data.apiservices.EverythingApiService
import com.example.newsapp.data.apiservices.HeadlineApiService
import com.example.newsapp.data.apiservices.SourceApiServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient: OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(providerInspector())
            .connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build()

    private fun providerInspector(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val retrofitClient = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun providerApiService(): EverythingApiService = retrofitClient.create(
        EverythingApiService::class.java
    )

    fun providerHeadlineApiService(): HeadlineApiService = retrofitClient.create(
        HeadlineApiService::class.java
    )

    fun provideSourceApi(): SourceApiServices = retrofitClient.create(
        SourceApiServices::class.java
    )
}
package com.example.newsapp.data.apiservices

import com.example.newsapp.models.EverythingModel
import com.example.newsapp.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {

    @GET("/v2/everything?apiKey=e0f37cd53f044659a4911ed116efb54f")
    suspend fun fetchEverything(
        @Query("q") query: String,
        @Query("page") page: Int,
    ): NewsResponse<EverythingModel>
}

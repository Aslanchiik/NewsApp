package com.example.newsapp.data.apiservices

import com.example.newsapp.models.EverythingModel
import com.example.newsapp.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadlineApiService {

    @GET("/v2/top-headlines?apiKey=e0f37cd53f044659a4911ed116efb54f")
    suspend fun fetchHeadline(
        @Query("q") query: String,
        @Query("page") page : Int
    ) : NewsResponse<EverythingModel>
}
package com.example.newsapp.data.apiservices

import com.example.newsapp.models.NewsResponse
import com.example.newsapp.models.Source
import retrofit2.http.GET
import retrofit2.http.Query

interface SourceApiServices {

    @GET("/v2/top-headlines/sources?apiKey=e0f37cd53f044659a4911ed116efb54f")
    suspend fun fetchSource(
        @Query("country") query: String,
        @Query("page") page: Int
    ): NewsResponse<Source>
}
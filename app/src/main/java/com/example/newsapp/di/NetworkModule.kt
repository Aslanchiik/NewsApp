package com.example.newsapp.di

import com.example.newsapp.data.RetrofitClient
import com.example.newsapp.data.apiservices.EverythingApiService
import com.example.newsapp.data.apiservices.HeadlineApiService
import com.example.newsapp.data.apiservices.SourceApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient: RetrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun providers(): EverythingApiService {
        return retrofitClient.providerApiService()
    }

    @Singleton
    @Provides
    fun providerHeadline(): HeadlineApiService {
        return retrofitClient.providerHeadlineApiService()
    }

    @Singleton
    @Provides
    fun provideSource(): SourceApiServices{
        return retrofitClient.provideSourceApi()
    }
}
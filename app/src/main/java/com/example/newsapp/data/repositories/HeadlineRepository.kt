package com.example.newsapp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapp.data.apiservices.HeadlineApiService
import com.example.newsapp.data.repositories.pagingsource.HeadlineSource
import com.example.newsapp.models.EverythingModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HeadlineRepository @Inject constructor(
    private val service: HeadlineApiService
) {
    fun getHeadlineList(): Flow<PagingData<EverythingModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                HeadlineSource(service)
            }
        ).flow
    }
}
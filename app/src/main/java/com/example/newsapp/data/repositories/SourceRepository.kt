package com.example.newsapp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapp.data.apiservices.SourceApiServices
import com.example.newsapp.data.repositories.pagingsource.SourceSource
import com.example.newsapp.models.Source
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SourceRepository @Inject constructor(
    private val services: SourceApiServices
) {
    fun getSourceList(): Flow<PagingData<Source>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SourceSource(services)
            }
        ).flow
    }
}
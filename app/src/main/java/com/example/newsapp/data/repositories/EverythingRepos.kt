package com.example.newsapp.data.repositories

import androidx.paging.*
import com.example.newsapp.data.apiservices.EverythingApiService
import com.example.newsapp.data.repositories.pagingsource.EverythingSource
import com.example.newsapp.models.EverythingModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EverythingRepos @Inject constructor(
    private val service: EverythingApiService
) {
    fun getEverythingList(): Flow<PagingData<EverythingModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EverythingSource(service)
            }
        ).flow
    }

//            config = PagingConfig(
//                pageSize = 10,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = {
//                CharacterPagingSource(service)
//            }).flow

//    val movies: Flow<PagingData<EverythingModel>> = Pager(PagingConfig(pageSize = 20)) {
//        EverythingSource(service)
//    }.flow
//        .cachedIn(viewModelScope)
//) : BaseRepository() {
//
//    fun fetchEverything(
//        query: String = "bitcoin"
//    ) = doRequest {
//        service.fetchEverything(
//            query,
//            10
//        )
//    }
}
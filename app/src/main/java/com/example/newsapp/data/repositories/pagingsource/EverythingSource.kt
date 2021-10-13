package com.example.newsapp.data.repositories.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsapp.data.apiservices.EverythingApiService
import com.example.newsapp.models.EverythingModel

private const val EVERYTHING_PAGE = 1

class EverythingSource(private var service: EverythingApiService) :
    PagingSource<Int, EverythingModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EverythingModel> {
        return try {
            val nextPage = params.key ?: EVERYTHING_PAGE
            val response = service.fetchEverything("bitcoin", nextPage)
            val nextPages = nextPage + 1

            LoadResult.Page(
                data = response.articles,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPages
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, EverythingModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
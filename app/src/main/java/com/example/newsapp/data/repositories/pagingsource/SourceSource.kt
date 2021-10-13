package com.example.newsapp.data.repositories.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsapp.data.apiservices.SourceApiServices
import com.example.newsapp.models.Source

private const val SOURCE_PAGE = 1

class SourceSource(private var service: SourceApiServices) :
    PagingSource<Int, Source>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Source> {
        return try {
            val nextPage = params.key ?: SOURCE_PAGE
            val response = service.fetchSource("us", nextPage)
            val nextPages = nextPage + 1

            LoadResult.Page(
                data = response.sources,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPages
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Source>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}

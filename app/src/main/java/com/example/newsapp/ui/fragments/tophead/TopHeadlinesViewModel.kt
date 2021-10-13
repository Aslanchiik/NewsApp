package com.example.newsapp.ui.fragments.tophead

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapp.bases.BaseViewModel
import com.example.newsapp.data.repositories.HeadlineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesViewModel @Inject constructor(
    private val repos: HeadlineRepository
) : BaseViewModel() {

    fun hiltHeadline() = repos.getHeadlineList().cachedIn(viewModelScope)
}
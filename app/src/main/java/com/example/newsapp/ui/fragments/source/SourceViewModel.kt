package com.example.newsapp.ui.fragments.source

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapp.bases.BaseViewModel
import com.example.newsapp.data.repositories.SourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SourceViewModel @Inject constructor(
    private val repos: SourceRepository
) : BaseViewModel() {

    fun hiltSource() = repos.getSourceList().cachedIn(viewModelScope)
}
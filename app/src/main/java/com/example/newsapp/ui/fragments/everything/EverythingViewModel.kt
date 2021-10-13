package com.example.newsapp.ui.fragments.everything

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapp.bases.BaseViewModel
import com.example.newsapp.data.repositories.EverythingRepos
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EverythingViewModel @Inject constructor(
    private val repository: EverythingRepos
) : BaseViewModel() {

    fun hiltEverything() = repository.getEverythingList().cachedIn(viewModelScope)

//    fun getEverything() {
//        viewModelScope.launch {
//            repository.fetchEverything().collect {
//                when (it) {
//                    is Resource.Loading -> {
//                        Log.d("tag", "loading-wait")
//                    }
//                    is Resource.Success -> {
//                        Log.d("tag", "isGood")
//                    }
//                    is Resource.Error -> {
//                        Log.d("tag", "error please wait")
//                    }
//                }
//            }
//        }
//
//    }
}
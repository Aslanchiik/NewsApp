package com.example.newsapp.ui.fragments.tophead

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapp.R
import com.example.newsapp.bases.BaseFragment
import com.example.newsapp.databinding.FragmentTopHeadlineBinding
import com.example.newsapp.ui.adapters.HeadlineAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopHeadlineFragment :
    BaseFragment<FragmentTopHeadlineBinding, TopHeadlinesViewModel>(R.layout.fragment_top_headline) {

    override val binding by viewBinding(FragmentTopHeadlineBinding::bind)
    override val viewModel: TopHeadlinesViewModel by viewModels()
    private val headlineAdapter: HeadlineAdapter = HeadlineAdapter()

    override fun initialize() {
        binding.recViewOfHeadline.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = headlineAdapter
        }
    }

    override fun setupListener() {
        progressListener()
    }

    private fun progressListener() {
        headlineAdapter.addLoadStateListener {
            binding.recViewOfHeadline.isVisible = it.refresh != LoadState.Loading
            binding.progressBar.isVisible = it.refresh == LoadState.Loading
        }
    }

    override fun setupRequest() {
        lifecycleScope.launch {
            viewModel.hiltHeadline().collect {
                headlineAdapter.submitData(it)
            }
        }
    }

}
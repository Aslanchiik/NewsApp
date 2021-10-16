package com.example.newsapp.ui.fragments.source

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapp.R
import com.example.newsapp.bases.BaseFragment
import com.example.newsapp.databinding.FragmentSourceBinding
import com.example.newsapp.ui.adapters.SourceAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SourceFragment :
    BaseFragment<FragmentSourceBinding, SourceViewModel>(R.layout.fragment_source) {

    override val binding by viewBinding(FragmentSourceBinding::bind)
    override val viewModel: SourceViewModel by viewModels()
    private val sourceAdapter: SourceAdapter = SourceAdapter()

    override fun initialize() {
        binding.recViewOfSource.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sourceAdapter
        }
    }

    override fun setupListener() {
        progressListener()
    }

    private fun progressListener() {
        sourceAdapter.addLoadStateListener {
            binding.recViewOfSource.isVisible = it.refresh != LoadState.Loading
            binding.progressBar.isVisible = it.refresh == LoadState.Loading
        }
    }

    override fun setupRequest() {
        lifecycleScope.launch {
            viewModel.hiltSource().collect {
                sourceAdapter.submitData(it)
            }
        }
    }
}
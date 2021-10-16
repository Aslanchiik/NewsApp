package com.example.newsapp.ui.fragments.everything

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapp.R
import com.example.newsapp.bases.BaseFragment
import com.example.newsapp.databinding.FragmentEverythingBinding
import com.example.newsapp.ui.adapters.EverythingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<FragmentEverythingBinding, EverythingViewModel>(R.layout.fragment_everything) {

    override val binding by viewBinding(FragmentEverythingBinding::bind)
    override val viewModel: EverythingViewModel by viewModels()
    private val everythingAdapter: EverythingAdapter = EverythingAdapter()

    override fun initialize() {
        binding.recView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = everythingAdapter
        }
    }

    override fun setupListener() {
        adapterListener()
    }

    private fun adapterListener() {
        everythingAdapter.addLoadStateListener {
            binding.recView.isVisible = it.refresh != LoadState.Loading
            binding.progressBar.isVisible = it.refresh == LoadState.Loading
        }
    }

    override fun setupRequest() {
        lifecycleScope.launch {
            viewModel.fetchEverything().collectLatest {
                Log.d("tag", "myInform")
                everythingAdapter.submitData(it)
//                binding.progressBar.visibility = View.GONE
            }
        }
    }
}

package com.example.newsapp.ui.fragments.everything

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapp.R
import com.example.newsapp.bases.BaseFragment
import com.example.newsapp.databinding.FragmentEverythingBinding
import com.example.newsapp.ui.adapters.EverythingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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

    override fun setupRequest() {
        lifecycleScope.launch {
            viewModel.hiltEverything().collect {
                Log.d("tag", "myInform")
                everythingAdapter.submitData(it)
            }
        }
    }
}
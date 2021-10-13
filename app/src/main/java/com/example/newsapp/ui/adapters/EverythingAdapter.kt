package com.example.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.bases.BaseDiffUtilItemCallback
import com.example.newsapp.databinding.ItemEvreythingBinding
import com.example.newsapp.models.EverythingModel

class EverythingAdapter :
    PagingDataAdapter<EverythingModel, EverythingAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemEvreythingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(it: EverythingModel) {
            binding.itemTitle.text = it.title
            binding.itemDesc.text = it.description
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEvreythingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}
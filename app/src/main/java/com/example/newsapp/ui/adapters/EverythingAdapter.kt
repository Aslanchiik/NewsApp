package com.example.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.bases.BaseDiffUtilItemCallback
import com.example.newsapp.databinding.ItemEvreythingBinding
import com.example.newsapp.models.EverythingModel
import kotlinx.coroutines.GlobalScope

class EverythingAdapter :
    PagingDataAdapter<EverythingModel, EverythingAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemEvreythingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(it: EverythingModel) {
            with(binding) {
                Glide.with(mainImage).load(it.urlToImage).into(mainImage)
                itemTitle.text = it.title
                itemDesc.text = it.description

            }
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
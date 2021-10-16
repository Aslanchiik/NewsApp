package com.example.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.bases.BaseDiffUtilItemCallback
import com.example.newsapp.databinding.ItemHeadlineBinding
import com.example.newsapp.models.EverythingModel

class HeadlineAdapter :
    PagingDataAdapter<EverythingModel, HeadlineAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemHeadlineBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(it: EverythingModel) {
            with(binding){
                Glide.with(mainImage).load(it.urlToImage).into(mainImage)
                mainText.text = it.title
                descText.text = it.description
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHeadlineBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }
}
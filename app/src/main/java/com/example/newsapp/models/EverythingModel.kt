package com.example.newsapp.models

import com.example.newsapp.bases.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class EverythingModel(

    @SerializedName("source")
    val source: Source,

    @SerializedName("author")
    val author: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    override val url: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("urlToImage")
    val urlToImage: String,

    @SerializedName("publishAt")
    val publishAt: String,

    @SerializedName("content")
    val content: String,
) : IBaseDiffModel

data class Source(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    override val url: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("language")
    val language: String

) : IBaseDiffModel
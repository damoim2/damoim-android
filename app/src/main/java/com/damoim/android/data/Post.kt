package com.damoim.android.data

data class Post(
    val writer: String,
    val writerProfileImage: String,
    val date: String,
    val contents: String,
    val likes: Int,
    val isLike: Boolean,
    val comments: List<String>?,
    val image: List<String>?
)
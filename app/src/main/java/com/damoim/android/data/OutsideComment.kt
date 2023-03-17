package com.damoim.android.data

data class OutsideComment(
    val profileImg: String,
    val name: String,
    val contents: String,
    val reComments: List<InsideComment>,
    val date: String
)
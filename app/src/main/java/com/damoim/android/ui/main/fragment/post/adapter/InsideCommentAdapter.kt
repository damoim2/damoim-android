package com.damoim.android.ui.main.fragment.post.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.damoim.android.data.InsideComment
import com.damoim.android.data.Post
import com.damoim.android.databinding.GroupPostItemBinding
import com.damoim.android.databinding.InsideCommentItemBinding
import com.damoim.android.ui.main.fragment.group.adapter.GroupPostViewHolder

class InsideCommentAdapter: RecyclerView.Adapter<InsideCommentViewHolder>() {
    private val items = ArrayList<InsideComment>()

    fun setItemList(newItems: List<InsideComment>) {
        items.run {
            clear()
            addAll(newItems)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsideCommentViewHolder {
        return InsideCommentViewHolder(InsideCommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: InsideCommentViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
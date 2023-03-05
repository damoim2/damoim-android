package com.damoim.android.ui.main.fragment.group.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.damoim.android.data.Post
import com.damoim.android.databinding.GroupPostItemBinding


class GroupPostAdapter : RecyclerView.Adapter<GroupPostViewHolder>() {
    private val items = ArrayList<Post>()

    fun setItemList(newItems: List<Post>) {
        items.run {
            clear()
            addAll(newItems)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupPostViewHolder {
        return GroupPostViewHolder(GroupPostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GroupPostViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
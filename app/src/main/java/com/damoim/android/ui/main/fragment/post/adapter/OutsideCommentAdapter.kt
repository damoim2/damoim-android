package com.damoim.android.ui.main.fragment.post.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.damoim.android.data.InsideComment
import com.damoim.android.data.OutsideComment
import com.damoim.android.databinding.InsideCommentItemBinding
import com.damoim.android.databinding.OutsideCommentItemBinding

class OutsideCommentAdapter : RecyclerView.Adapter<OutsideCommentViewHolder>() {
    private val items = ArrayList<OutsideComment>()

    fun setItemList(newItems: List<OutsideComment>) {
        items.run {
            clear()
            addAll(newItems)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OutsideCommentViewHolder {
        return OutsideCommentViewHolder(OutsideCommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: OutsideCommentViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
package com.damoim.android.ui.main.fragment.home.adapter

import android.graphics.Movie
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.damoim.android.data.Group
import com.damoim.android.databinding.HomeGroupAddItemBinding
import com.damoim.android.databinding.HomeGroupItemBinding

class HomeGroupAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = ArrayList<Group>()
    private lateinit var listener: () -> Unit

    fun setClickListener(newListener: () -> Unit) {
        listener = newListener
    }

    companion object {
        const val ITEM = 1
        const val FOOTER = 2
    }
    fun setItemList(newItems: List<Group>) {
        items.run {
            clear()
            addAll(newItems)
            add(Group("", ""))
        }
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == items.size.minus(1))
            FOOTER
        else
            ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM) {
            HomeGroupViewHolder(
                HomeGroupItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), listener)
        } else {
            HomeGroupAddViewHolder(
                HomeGroupAddItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HomeGroupViewHolder -> holder.bind(items[position])
            is HomeGroupAddViewHolder -> holder.bind()
        }
    }

    override fun getItemCount() = items.size
}
package com.damoim.android.ui.main.fragment.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.damoim.android.data.Group
import com.damoim.android.data.Schedule
import com.damoim.android.databinding.ScheduleItemBinding

class GroupScheduleAdapter : RecyclerView.Adapter<GroupScheduleViewHolder>() {
    private val items = ArrayList<Schedule>()

    fun setItemList(newItems: List<Schedule>) {
        items.run {
            clear()
            addAll(newItems)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupScheduleViewHolder {
        return GroupScheduleViewHolder(ScheduleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GroupScheduleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
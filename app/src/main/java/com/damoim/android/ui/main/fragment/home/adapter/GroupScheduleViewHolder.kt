package com.damoim.android.ui.main.fragment.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.damoim.android.data.Group
import com.damoim.android.data.Schedule
import com.damoim.android.databinding.ScheduleItemBinding

class GroupScheduleViewHolder (private val binding: ScheduleItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Schedule) {
        with(binding) {
            scheduleItemTxtTitle.text = item.title
            scheduleItemTxtDate.text = item.date
            scheduleItemTxtTime.text = item.time
        }
    }
}
package com.damoim.android.ui.main.fragment.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.damoim.android.R
import com.damoim.android.data.Group
import com.damoim.android.databinding.HomeGroupItemBinding

class HomeGroupViewHolder(private val binding: HomeGroupItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Group) {
        binding.apply {
            homeGroupItemTxt.text = item.title

            Glide.with(itemView.context).load(item.img)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(homeGroupItemImg)
        }
    }
}
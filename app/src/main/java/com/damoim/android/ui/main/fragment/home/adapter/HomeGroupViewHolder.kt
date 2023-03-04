package com.damoim.android.ui.main.fragment.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.damoim.android.R
import com.damoim.android.data.Group
import com.damoim.android.databinding.HomeGroupItemBinding

class HomeGroupViewHolder(private val binding: HomeGroupItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Group) {
        with(binding) {
            homeGroupItemTxt.text = item.title

            Glide.with(itemView.context).load(item.img)
                .placeholder(R.drawable.img_defult_group)
                .error(R.drawable.img_defult_group)
                .transform(CenterCrop(), RoundedCorners(16))
                .into(homeGroupItemImg)
        }
    }
}
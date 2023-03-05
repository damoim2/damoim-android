package com.damoim.android.ui.main.fragment.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.damoim.android.R
import com.damoim.android.data.Group
import com.damoim.android.databinding.HomeGroupItemBinding

class HomeGroupViewHolder(
    private val binding: HomeGroupItemBinding,
    private val listener: () -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        itemView.setOnClickListener {
            listener()
        }
    }

    fun bind(item: Group) {
        with(binding) {
            homeGroupItemTxt.text = item.title

            Glide.with(itemView.context).load(item.img)
                .placeholder(R.drawable.img_default_group)
                .error(R.drawable.img_default_group)
                .transform(CenterCrop())
                .into(homeGroupItemImg)

        }
    }
}
package com.damoim.android.ui.main.fragment.image.adapter


import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.damoim.android.databinding.ImageItemBinding

class ImageViewHolder(
    private val binding: ImageItemBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item: String) {
        Glide.with(itemView.context).load(item).into(binding.imageItemImg)
    }
}
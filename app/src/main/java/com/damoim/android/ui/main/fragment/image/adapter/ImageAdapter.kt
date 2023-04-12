package com.damoim.android.ui.main.fragment.image.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.damoim.android.databinding.ImageItemBinding

class ImageAdapter :
    RecyclerView.Adapter<ImageViewHolder>() {
    private val images = ArrayList<String>()

    fun setImageList(items: List<String>) {
        images.run {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding =
            ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount() = images.size
}

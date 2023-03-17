package com.damoim.android.ui.main.fragment.post.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.damoim.android.R
import com.damoim.android.data.InsideComment
import com.damoim.android.databinding.InsideCommentItemBinding

class InsideCommentViewHolder (
    private val binding: InsideCommentItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: InsideComment) {
        with(binding) {
            Glide.with(itemView.context).load(item.profileImg)
                .error(R.drawable.img_default_profile)
                .placeholder(R.drawable.img_default_profile)
                .transform(CenterCrop())
                .into(insideCommentItemImgWriterProfileImg)

            insideCommentItemTxtWriterName.text = item.name

            insideCommentItemTxtContents.text = item.contents

            insideCommentItemTxtDate.text = item.date
        }
    }
}
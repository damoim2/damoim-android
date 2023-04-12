package com.damoim.android.ui.main.fragment.post.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.damoim.android.R
import com.damoim.android.data.OutsideComment
import com.damoim.android.databinding.OutsideCommentItemBinding

class OutsideCommentViewHolder(
    private val binding: OutsideCommentItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: OutsideComment) {
        with(binding) {
            Glide.with(itemView.context).load(item.profileImg)
                .error(R.drawable.img_default_profile)
                .placeholder(R.drawable.img_default_profile)
                .transform(CenterCrop())
                .into(outsideCommentItemImgWriterProfileImg)

            outsideCommentItemTxtWriterName.text = item.name

            outsideCommentItemTxtContents.text = item.contents

            outsideCommentItemTxtDate.text = item.date
        }
    }
}
package com.damoim.android.ui.main.fragment.group.adapter

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.damoim.android.R
import com.damoim.android.data.Post
import com.damoim.android.databinding.GroupPostItemBinding

class GroupPostViewHolder(
    private val binding: GroupPostItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.groupPostItemTxtMore.setOnClickListener {
            itemView.findNavController().navigate(R.id.action_groupFragment_to_postFragment)
        }
    }
    fun bind(item: Post) {
        with(binding) {
            Glide.with(itemView.context).load(item.writerProfileImage)
                .error(R.drawable.img_default_profile)
                .placeholder(R.drawable.img_default_profile)
                .transform(CenterCrop())
                .into(groupPostItemImgWriterProfileImg)

            if (item.image.isNullOrEmpty()) {
                groupPostItemConstraintContentsImgContainer.visibility = GONE
            } else {
                groupPostItemConstraintContentsImgContainer.visibility = VISIBLE
                Glide.with(itemView.context).load(item.image[0])
                    .error(R.drawable.img_default_group)
                    .placeholder(R.drawable.img_default_group)
                    .transform(CenterCrop())
                    .into(groupPostItemImgContentsImg)

                if (item.image.size > 1) {
                    groupPostItemTxtContentsImgCount.text = item.image.size.toString()
                    groupPostItemCardContentsImgCountContainer.visibility = VISIBLE
                } else {
                    groupPostItemCardContentsImgCountContainer.visibility = GONE
                }
            }

            if (item.isLike) {
               groupPostItemImgLike.setImageResource(R.drawable.ic_like_fill)
            }

            groupPostItemTxtWriterName.text = item.writer
            groupPostItemTxtDate.text = item.date
            groupPostItemTxtContents.text = item.contents
            groupPostItemTxtLike.text = "좋아요 ${item.likes}개"
            groupPostItemTxtComment.text = "댓글 ${(item.comments?.size ?: "0")}개"
        }
    }
}
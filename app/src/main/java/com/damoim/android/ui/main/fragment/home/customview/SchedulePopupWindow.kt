package com.damoim.android.ui.main.fragment.home.customview

import android.widget.LinearLayout
import android.widget.PopupWindow
import com.damoim.android.R
import com.damoim.android.data.Schedule
import com.damoim.android.databinding.PopupWindowBinding
import com.damoim.android.ui.main.fragment.home.adapter.GroupScheduleAdapter


class SchedulePopupWindow(
    private val binding: PopupWindowBinding,
    private val adapter: GroupScheduleAdapter,
    private val items: List<Schedule>,
) : PopupWindow(
    binding.root,
    LinearLayout.LayoutParams.MATCH_PARENT,
    LinearLayout.LayoutParams.WRAP_CONTENT,
    false) {

    init {
        setupView()
        animationStyle = R.style.PopupWindowAnimation
    }

    private fun setupView() {
        binding.popupWindowRecyclerview.adapter = adapter
        adapter.setItemList(items)

        binding.popupWindowImgDropUpBtn.setOnClickListener {
            dismiss()
        }

        contentView = binding.root
    }
}

package com.damoim.android.ui.main.fragment.group

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.damoim.android.R
import com.damoim.android.base.BaseFragment
import com.damoim.android.data.Post
import com.damoim.android.databinding.FragmentGroupBinding
import com.damoim.android.ui.main.fragment.group.adapter.GroupPostAdapter


class GroupFragment : BaseFragment<FragmentGroupBinding>(
    FragmentGroupBinding::bind,
    R.layout.fragment_group
), GroupContract.View {
    private val groupPostAdapter by lazy { GroupPostAdapter() }

    private val testItems = arrayListOf(
        Post(
            "황혁주",
            "",
            "12월 13일",
            "인류의 하였으며, 간에 튼튼하며, 사막이다. 긴지라 방지하는 거친 기관과 그것을 우리 고행을 무엇이 꽃이 이것이다. 무한한 아름답고 영락과 이것이다.",
            11,
            false,
            arrayListOf(),
            arrayListOf("", "")
        ),
        Post(
            "황혁주",
            "",
            "12월 13일",
            "인류의 하였으며, 간에 튼튼하며, 사막이다. 긴지라 방지하는 거친 기관과 그것을 우리 고행을 무엇이 꽃이 이것이다. 무한한 아름답고 영락과 이것이다.",
            11,
            true,
            arrayListOf("ㅎㅇ"),
            null
        ),
        Post(
            "황혁주",
            "",
            "12월 13일",
            "인류의 하였으며, 간에 튼튼하며, 사막이다. 긴지라 방지하는 거친 기관과 그것을 우리 고행을 무엇이 꽃이 이것이다. 무한한 아름답고 영락과 이것이다.",
            11,
            true,
            arrayListOf("ㅎㅇ", "ㅎㅇ"),
            arrayListOf("", "", "")
        ),
        Post(
            "황혁주",
            "",
            "12월 13일",
            "인류의 하였으며, 간에 튼튼하며, 사막이다. 긴지라 방지하는 거친 기관과 그것을 우리 고행을 무엇이 꽃이 이것이다. 무한한 아름답고 영락과 이것이다.",
            11,
            false,
            arrayListOf("ㅎㅇ", "ㅎㅇ", "ㅎㅇ"),
            arrayListOf("")
        ),
        Post(
            "황혁주",
            "",
            "12월 13일",
            "인류의 하였으며, 간에 튼튼하며, 사막이다. 긴지라 방지하는 거친 기관과 그것을 우리 고행을 무엇이 꽃이 이것이다. 무한한 아름답고 영락과 이것이다.",
            11,
            false,
            arrayListOf("ㅎㅇ", "ㅎㅇ", "ㅎㅇ"),
            null
        ),
        Post(
            "황혁주",
            "",
            "12월 13일",
            "인류의 하였으며, 간에 튼튼하며, 사막이다. 긴지라 방지하는 거친 기관과 그것을 우리 고행을 무엇이 꽃이 이것이다. 무한한 아름답고 영락과 이것이다.",
            11,
            false,
            arrayListOf("ㅎㅇ", "ㅎㅇ", "ㅎㅇ"),
            arrayListOf("")
        ),
        Post(
            "황혁주",
            "",
            "12월 13일",
            "인류의 하였으며, 간에 튼튼하며, 사막이다. 긴지라 방지하는 거친 기관과 그것을 우리 고행을 무엇이 꽃이 이것이다. 무한한 아름답고 영락과 이것이다.",
            11,
            false,
            arrayListOf("ㅎㅇ", "ㅎㅇ", "ㅎㅇ"),
            null
        ),
        Post(
            "황혁주",
            "",
            "12월 13일",
            "인류의 하였으며, 간에 튼튼하며, 사막이다. 긴지라 방지하는 거친 기관과 그것을 우리 고행을 무엇이 꽃이 이것이다. 무한한 아름답고 영락과 이것이다.",
            11,
            false,
            arrayListOf("ㅎㅇ", "ㅎㅇ", "ㅎㅇ"),
            null
        ),
        Post(
            "황혁주",
            "",
            "12월 13일",
            "인류의 하였으며, 간에 튼튼하며, 사막이다. 긴지라 방지하는 거친 기관과 그것을 우리 고행을 무엇이 꽃이 이것이다. 무한한 아름답고 영락과 이것이다.",
            11,
            false,
            arrayListOf("ㅎㅇ", "ㅎㅇ", "ㅎㅇ"),
            null
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        with(binding) {
            groupRecyclerview.adapter = groupPostAdapter
            groupPostAdapter.setItemList(testItems)

            Glide.with(this@GroupFragment)
                .load(R.drawable.img_default_group)
                .into(groupImgHeaderBackground)

            groupImgBackBtn.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}
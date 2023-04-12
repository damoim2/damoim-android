package com.damoim.android.ui.main.fragment.post

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.damoim.android.R
import com.damoim.android.base.BaseFragment
import com.damoim.android.data.InsideComment
import com.damoim.android.data.OutsideComment
import com.damoim.android.databinding.FragmentPostBinding
import com.damoim.android.ui.main.fragment.post.adapter.OutsideCommentAdapter
import com.damoim.android.util.KeyboardVisibilityUtils



class PostFragment :
    BaseFragment<FragmentPostBinding>(FragmentPostBinding::bind, R.layout.fragment_post),
    PostContract.View {
    private lateinit var keyboardVisibilityUtils: KeyboardVisibilityUtils
    private val commentAdapter by lazy { OutsideCommentAdapter() }

    private val testItems = arrayListOf<OutsideComment>(
        OutsideComment(
            "", "황혁주", "ㅎㅇㅎㅇ", arrayListOf(
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일")
            ), "12월 13일"
        ), OutsideComment(
            "", "황혁주", "ㅎㅇㅎㅇ", arrayListOf(
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일")
            ), "12월 13일"
        ), OutsideComment(
            "", "황혁주", "ㅎㅇㅎㅇ", arrayListOf(
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일")
            ), "12월 13일"
        ), OutsideComment(
            "", "황혁주", "ㅎㅇㅎㅇ", arrayListOf(
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일")
            ), "12월 13일"
        ), OutsideComment(
            "", "황혁주", "ㅎㅇㅎㅇ", arrayListOf(
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일")
            ), "12월 13일"
        ), OutsideComment(
            "", "황혁주", "ㅎㅇㅎㅇ", arrayListOf(
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일"),
                InsideComment("", "황혁주", "ㅎㅇㅎㅇㅎㅇ", "12월 13일")
            ), "12월 13일"
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initView() {
        with(binding) {
            postRecyclerComments.adapter = commentAdapter
            commentAdapter.setItemList(testItems)
            postItemTxtDate.text = "12월 13일"
            postItemTxtLike.text = "10"
            postTxtComment.text = "10"
            postTxtContents.text =
                "있는 그들의 커다란 주며, 든 이는 철환하였는가? 노년에게서 끓는 우리 이 살았으며, 더운지라 웅대한 모래뿐일 때문이다. 설산에서 것이 얼음 같은 것이다. 청춘은 할지라도 가치를 풍부하게 장식하는 보배를 날카로우나 것이다. 바이며, 아니더면, 반짝이는 있다. 되려니와, 때까지 피가 희망의 과실이 밥을 온갖 듣는다. 창공에 간에 능히 낙원을 속에 방지하는 착목한는 속에서 구하기 봄바람이다. 물방아 노래하며 생의 뜨거운지라, 가치를 이상 인생을 인간이 들어 있다. 커다란 인생의 자신과 황금시대를 가진 내는 모래뿐일 인생을 봄바람이다. 인생에 풀밭에 몸이 같이, 생명을 칼이다. 예수는 우리 평화스러운 듣는다."
            postItemTxtWriterName.text = "황혁주"
            postTxtTag.visibility = INVISIBLE
            postTxtTitle.text = "계모임 이름"
            postImgBack.setOnClickListener {
                findNavController().popBackStack()
            }

            postLlMainImgContainer.setOnClickListener {
                findNavController().navigate(R.id.action_postFragment_to_imageFragment)
            }
        }

        // TODO: 백그라운드 변경 시 뒷 배경이 나오지 않도록 수정
        keyboardVisibilityUtils = KeyboardVisibilityUtils(requireActivity().window, onShowKeyboard = { _, _ ->
            // 키보드가 올라올 때의 동작
            binding.postImgBtn.visibility = VISIBLE
            // binding.postLlCommentInputBox.background = resources.getDrawable(R.drawable.bg_layout_gray07_top_purple04_round, null)
        }, onHideKeyboard = {
            // 키보드가 내려갈 때의 동작
            binding.postImgBtn.visibility = INVISIBLE
            //  binding.postLlCommentInputBox.background = resources.getDrawable(R.drawable.bg_layout_gray07_top_purple04, null)
        })
    }

    override fun onDestroyView() {
        keyboardVisibilityUtils.detachKeyboardListeners()
        super.onDestroyView()
    }
}
package com.damoim.android.ui.main.fragment.home

import android.os.Bundle
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.damoim.android.R
import com.damoim.android.base.BaseFragment
import com.damoim.android.data.Group
import com.damoim.android.databinding.FragmentHomeBinding
import com.damoim.android.ui.main.fragment.chat.ChatContract
import com.damoim.android.ui.main.fragment.home.adapter.HomeGroupAdapter
import timber.log.Timber

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind,
    R.layout.fragment_home), HomeContract.View {
    private val groupAdapter by lazy { HomeGroupAdapter() }

    private val testItems = arrayListOf<Group>(
        Group("", "테스트1"),
        Group("", "테스트2"),
        Group("", "테스트3"),
        Group("", "테스트4"),
        Group("", "테스트5"),
        Group("", "테스트6"),
        Group("", "테스트7")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        Timber.tag("lifecycle").d("onViewCreated")

    }

    private fun initView() {
        binding.homeRecyclerview.adapter = groupAdapter
        groupAdapter.setMovieList(testItems)

        binding.homeRadioBtn1.setOnClickListener {
            onRadioButtonClicked(it)
        }

        binding.homeRadioBtn2.setOnClickListener {
            onRadioButtonClicked(it)
        }

    }

    private fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            when (view.getId()) {
                R.id.home_radio_btn1 -> {
                    val layoutManager = GridLayoutManager(context, 2)
                    binding.homeRecyclerview.layoutManager = layoutManager
                    binding.homeRadioBtn2.isChecked = false
                }
                R.id.home_radio_btn2 -> {
                    val layoutManager = GridLayoutManager(context, 3)
                    binding.homeRecyclerview.layoutManager = layoutManager
                    binding.homeRadioBtn1.isChecked = false
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        binding.homeRadioBtn2.isChecked = false
        binding.homeRadioBtn1.isChecked = true
    }
}
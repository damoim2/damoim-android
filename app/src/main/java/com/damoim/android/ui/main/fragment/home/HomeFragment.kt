package com.damoim.android.ui.main.fragment.home

import com.damoim.android.R
import com.damoim.android.base.BaseFragment
import com.damoim.android.databinding.FragmentHomeBinding
import com.damoim.android.ui.main.fragment.chat.ChatContract

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind,
    R.layout.fragment_home), HomeContract.View {
}
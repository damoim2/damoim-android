package com.damoim.android.ui.main

import android.os.Bundle
import android.view.View
import com.damoim.android.R
import com.damoim.android.base.BaseActivity
import com.damoim.android.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun visibleBottomNavigation(isVisible: Boolean) {
        if (isVisible) {
            binding.mainBottom.visibility = View.VISIBLE
        } else {
            binding.mainBottom.visibility = View.GONE
        }
    }
}
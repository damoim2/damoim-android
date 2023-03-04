package com.damoim.android.ui.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.damoim.android.R
import com.damoim.android.base.BaseActivity
import com.damoim.android.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment

        val navController = navHostFragment.navController
        binding.mainBottom
            .setupWithNavController(navController)
    }

    fun visibleBottomNavigation(isVisible: Boolean) {
        if (isVisible) {
            binding.mainBottom.visibility = View.VISIBLE
        } else {
            binding.mainBottom.visibility = View.GONE
        }
    }
}
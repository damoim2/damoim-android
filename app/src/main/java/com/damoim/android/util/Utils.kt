package com.damoim.android.util

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class Utils {
    companion object {
        /**
         * 투명한 상단 statusbar가 포함된 풀스크린 모드를 액티비티에 적용하기 위한 메소드
         *
         * @param activity
         */
        @JvmStatic
        @SuppressLint("ObsoleteSdkInt")
        fun setFullScreenWithStatusBar(activity: AppCompatActivity) {
            activity.apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    @Suppress("DEPRECATION")
                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                }
            }
        }
    }
}
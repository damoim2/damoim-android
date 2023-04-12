package com.damoim.android.util

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
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

        @Suppress("DEPRECATION")
        fun Activity.setStatusBarColor(color:Int){
            var flags = window?.decorView?.systemUiVisibility // get current flag
            if (flags != null) {
                if(isColorDark(color)){
                    flags = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                    window?.decorView?.systemUiVisibility = flags
                }else{
                    flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    window?.decorView?.systemUiVisibility = flags
                }
            }
            window?.statusBarColor = color
        }

        private fun isColorDark(color:Int) : Boolean{
            val darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
            return darkness >= 0.5
        }
    }
}
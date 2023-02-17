package com.damoim.android

import android.app.Application
import timber.log.Timber

class DamoimApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}
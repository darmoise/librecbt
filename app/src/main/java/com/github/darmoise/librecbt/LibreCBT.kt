package com.github.darmoise.librecbt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm

@HiltAndroidApp
class LibreCBT : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}
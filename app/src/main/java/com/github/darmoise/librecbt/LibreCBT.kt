package com.github.darmoise.librecbt

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm

@HiltAndroidApp
class LibreCBT : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        AndroidThreeTen.init(this);
    }
}
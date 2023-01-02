package com.github.darmoise.librecbt

import android.app.Application
import com.github.darmoise.librecbt.di.ApplicationComponent
import io.realm.Realm

class LibreCBT : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }

    companion object {
        private lateinit var _component: ApplicationComponent
        val component get() = _component
    }
}
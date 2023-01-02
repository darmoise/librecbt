package com.github.darmoise.librecbt.di

import com.github.darmoise.librecbt.ui.fragment.FirstFragment
import dagger.Component
import io.realm.annotations.RealmModule
import javax.inject.Singleton

@Component(
    modules = [RealmModule::class]
)
@Singleton
interface ApplicationComponent {
    fun inject(fragment: FirstFragment)
}
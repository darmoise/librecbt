package com.github.darmoise.librecbt.di.module

import dagger.Module
import dagger.Provides
import io.realm.RealmConfiguration


@Module
class RealmModule {
    @Provides
    fun providesRealmConfiguration(): RealmConfiguration {
        return RealmConfiguration.Builder()
            .schemaVersion(REALM_VERSION)
            .build()
    }

    companion object {
        private const val REALM_VERSION = 1L
    }
}
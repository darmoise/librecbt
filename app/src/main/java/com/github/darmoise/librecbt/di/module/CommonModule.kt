package com.github.darmoise.librecbt.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.RealmConfiguration

@Module
@InstallIn(SingletonComponent::class)
class CommonModule {
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
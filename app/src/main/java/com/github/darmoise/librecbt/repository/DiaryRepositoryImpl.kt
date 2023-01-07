package com.github.darmoise.librecbt.repository

import io.realm.RealmConfiguration
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    private val realmConfiguration: RealmConfiguration
) : DiaryRepository {
    override fun get(): String {
        return "$realmConfiguration"
    }
}
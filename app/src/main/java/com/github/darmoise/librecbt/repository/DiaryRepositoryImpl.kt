package com.github.darmoise.librecbt.repository

import com.github.darmoise.librecbt.domain.entity.DiaryEntity
import com.github.darmoise.librecbt.domain.model.DiaryItem
import com.github.darmoise.librecbt.util.mapper.DiaryObjectMapper
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    private val realmConfiguration: RealmConfiguration
) : DiaryRepository {
    private val realm get() = Realm.getInstance(realmConfiguration)

    override fun getItems(): List<DiaryItem> {
        return realm.where(DiaryEntity::class.java)
            .findAll()
            .map(DiaryObjectMapper::entityToItem)
    }

    override fun saveItem(item: DiaryItem) {
        realm.executeTransaction {
            it.copyToRealm(
                DiaryObjectMapper.itemToEntity(item)
            )
        }
    }
}
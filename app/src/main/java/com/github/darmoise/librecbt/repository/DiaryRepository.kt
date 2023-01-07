package com.github.darmoise.librecbt.repository

import com.github.darmoise.librecbt.domain.model.DiaryItem

interface DiaryRepository {
    fun getItems(): List<DiaryItem>
    fun saveItem(item: DiaryItem)
}
package com.github.darmoise.librecbt.service

import com.github.darmoise.librecbt.domain.model.DiaryItem
import com.github.darmoise.librecbt.repository.DiaryRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DiaryService @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    fun getItems(): Single<List<DiaryItem>> {
        return Single.just(
            diaryRepository.getItems()
        )
    }

    fun saveItem(item: DiaryItem): Completable {
        return Completable.fromAction {
            diaryRepository.saveItem(item)
        }
    }
}
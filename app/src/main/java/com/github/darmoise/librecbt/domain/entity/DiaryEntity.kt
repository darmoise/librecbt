package com.github.darmoise.librecbt.domain.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class DiaryEntity(
    @PrimaryKey
    var id: UUID = UUID.randomUUID(),
    var event: String? = null, // Событие
    var thoughts: String? = null, // Мысли
    var emotions: String? = null, // Эмоции
    var reaction: String? = null, // Реакция
    var cognitiveDistortion: String? = null, // Когнитивное искажение
    var intensity: Int? = null, // Интенсивность
    var rationalAnswer: String? = null, // Рациональный ответ
    var time: String? = null
) : RealmObject()
package com.github.darmoise.librecbt.util.mapper

import com.github.darmoise.librecbt.domain.entity.DiaryEntity
import com.github.darmoise.librecbt.domain.model.DiaryItem
import org.threeten.bp.LocalDateTime

object DiaryObjectMapper {
    fun itemToEntity(item: DiaryItem): DiaryEntity {
        return DiaryEntity(
            id = item.id,
            event = item.event,
            thoughts = item.thoughts,
            emotions = item.emotions,
            reaction = item.reaction,
            cognitiveDistortion = item.cognitiveDistortion,
            intensity = item.intensity,
            rationalAnswer = item.rationalAnswer,
            time = item.time.toString()
        )
    }

    fun entityToItem(entity: DiaryEntity): DiaryItem {
        return DiaryItem(
            id = entity.id,
            event = entity.event!!,
            thoughts = entity.thoughts!!,
            emotions = entity.emotions!!,
            reaction = entity.reaction!!,
            cognitiveDistortion = entity.cognitiveDistortion!!,
            intensity = entity.intensity!!,
            rationalAnswer = entity.rationalAnswer!!,
            time = LocalDateTime.parse(entity.time!!)
        )
    }
}
package com.github.darmoise.librecbt.domain.ui

import org.threeten.bp.LocalDateTime
import java.util.*

data class DiaryUiItem(
    val id: UUID = UUID.randomUUID(),
    val event: String,
    val thoughts: String,
    val emotions: String,
    val reaction: String,
    val cognitiveDistortion: String,
    val intensity: Int,
    val rationalAnswer: String,
    val time: LocalDateTime
)
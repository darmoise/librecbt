package com.github.darmoise.librecbt.domain.state

import com.github.darmoise.librecbt.domain.ui.DiaryUiItem

sealed class DiaryState {
    object Loading : DiaryState()

    data class Content(
        val items: List<DiaryUiItem>
    ) : DiaryState()

    data class Error(
        val throwable: Throwable
    ) : DiaryState()

    object Empty : DiaryState()
}
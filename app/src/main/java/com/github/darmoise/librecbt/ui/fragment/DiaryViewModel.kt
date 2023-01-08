package com.github.darmoise.librecbt.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.darmoise.librecbt.domain.model.DiaryItem
import com.github.darmoise.librecbt.domain.state.DiaryState
import com.github.darmoise.librecbt.service.DiaryService
import com.github.darmoise.librecbt.util.addTo
import com.github.darmoise.librecbt.util.mapper.DiaryObjectMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class DiaryViewModel @Inject constructor(
    private val diaryService: DiaryService
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _state: MutableLiveData<DiaryState> = MutableLiveData(DiaryState.Empty)

    val state: LiveData<DiaryState> get() = _state

    init {
        updateDiary()
    }

    fun updateDiary() {
        diaryService.getItems()
            .delay(2, TimeUnit.SECONDS) // TODO: Remove
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _state.value = DiaryState.Loading
            }
            .subscribe(::setContentState, ::setErrorState)
            .addTo(compositeDisposable)
    }

    private fun setContentState(list: List<DiaryItem>) {
        val contentDiaryItems = list.map(DiaryObjectMapper::itemToUi)
        setState(
            DiaryState.Content(contentDiaryItems)
        )
    }

    private fun setErrorState(throwable: Throwable) {
        setState(
            DiaryState.Error(throwable)
        )
    }

    private fun setState(state: DiaryState) {
        _state.value = state
    }
}
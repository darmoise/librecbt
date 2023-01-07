package com.github.darmoise.librecbt.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.darmoise.librecbt.repository.DiaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository
) : ViewModel() {
    private val _mutableLiveData: MutableLiveData<String> = MutableLiveData()
    val liveDate: LiveData<String> get() = _mutableLiveData

    fun start() {
        _mutableLiveData.value = diaryRepository.get()
    }
}
package com.github.darmoise.librecbt.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.darmoise.librecbt.domain.model.DiaryItem
import com.github.darmoise.librecbt.service.DiaryService
import com.github.darmoise.librecbt.util.addTo
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.threeten.bp.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val diaryService: DiaryService
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _errorLiveData: MutableLiveData<Throwable> = MutableLiveData()

    private val _mutableLiveData: MutableLiveData<String> = MutableLiveData()


    private val _progressLiveData: MutableLiveData<Boolean> = MutableLiveData()

    val liveDate: LiveData<String> get() = _mutableLiveData

    val errorLiveData: LiveData<Throwable> get() = _errorLiveData
    val progressLiveData: LiveData<Boolean> get() = _progressLiveData

    fun start() {
        diaryService.saveItem(
            DiaryItem(
                event = "event",
                thoughts = "thoughts",
                emotions = "emotions",
                reaction = "reaction",
                cognitiveDistortion = "cognitiveDistortion",
                intensity = 1,
                rationalAnswer = "rationalAnswer",
                time = LocalDateTime.now()
            )
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _progressLiveData.value = true
            }
            .doOnTerminate {
                _progressLiveData.value = false
            }
            .subscribe({
                println("saved")
            }, {
                it.printStackTrace()
                _errorLiveData.value = it
            })
            .addTo(compositeDisposable)

        diaryService.getItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                println(it)
            }, {
                it.printStackTrace()
                _errorLiveData.value = it
            })
    }
}
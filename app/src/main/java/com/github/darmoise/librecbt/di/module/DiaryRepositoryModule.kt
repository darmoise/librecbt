package com.github.darmoise.librecbt.di.module

import com.github.darmoise.librecbt.repository.DiaryRepository
import com.github.darmoise.librecbt.repository.DiaryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DiaryRepositoryModule {
    @Binds
    abstract fun provideDiaryRepository(featureActivity: DiaryRepositoryImpl): DiaryRepository
}
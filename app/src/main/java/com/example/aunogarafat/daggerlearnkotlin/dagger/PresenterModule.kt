package com.example.aunogarafat.daggerlearnkotlin.dagger

import android.content.Context
import com.example.aunogarafat.daggerlearnkotlin.ui.homepage.presenter.NewsPresenter
import com.example.aunogarafat.daggerlearnkotlin.ui.homepage.presenter.NewsPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



/**
 * Created by aunogarafat on 2/28/18.
 * Project name DaggerLearnKotlin
 */
@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideNewsPresenter(context: Context): NewsPresenter {
        return NewsPresenterImpl(context)
    }
}
package com.example.aunogarafat.daggerlearnkotlin.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by aunogarafat on 2/28/18.
 * Project name DaggerLearnKotlin
 */
@Module
class AppModule(private val app: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = app
}
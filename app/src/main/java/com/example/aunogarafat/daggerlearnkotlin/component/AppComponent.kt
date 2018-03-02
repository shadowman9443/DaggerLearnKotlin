package com.example.aunogarafat.daggerlearnkotlin.component

import com.example.aunogarafat.daggerlearnkotlin.dagger.AppModule
import com.example.aunogarafat.daggerlearnkotlin.dagger.NetworkModule
import com.example.aunogarafat.daggerlearnkotlin.dagger.PresenterModule
import com.example.aunogarafat.daggerlearnkotlin.ui.homepage.HomeActivity
import com.example.aunogarafat.daggerlearnkotlin.ui.homepage.presenter.NewsPresenterImpl
import dagger.Component
import javax.inject.Singleton



/**
 * Created by aunogarafat on 2/28/18.
 * Project name DaggerLearnKotlin
 */
@Singleton
@Component(modules = [AppModule::class, PresenterModule::class, NetworkModule::class] )
interface AppComponent {
    fun inject( activity: HomeActivity)
    fun inject(target: NewsPresenterImpl)
}

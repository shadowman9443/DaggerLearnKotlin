package com.example.aunogarafat.daggerlearnkotlin.application

import android.app.Application
import com.example.aunogarafat.daggerlearnkotlin.component.AppComponent
import com.example.aunogarafat.daggerlearnkotlin.component.DaggerAppComponent
import com.example.aunogarafat.daggerlearnkotlin.dagger.AppModule


/**
 * Created by aunogarafat on 2/28/18.
 * Project name DaggerLearnKotlin
 */
class DagerKotlinApplication : Application() {
    lateinit var appComponent:AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent=initDagger(this)
    }

    private fun initDagger(dagerKotlinApplication: DagerKotlinApplication): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(dagerKotlinApplication))
                    .build()


}
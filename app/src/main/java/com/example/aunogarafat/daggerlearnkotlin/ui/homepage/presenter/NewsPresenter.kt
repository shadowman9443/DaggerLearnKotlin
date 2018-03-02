package com.example.aunogarafat.daggerlearnkotlin.ui.homepage.presenter

import com.example.aunogarafat.daggerlearnkotlin.ui.homepage.View.NewsView

/**
 * Created by aunogarafat on 2/28/18.
 * Project name DaggerLearnKotlin
 */
interface NewsPresenter {
    fun getNews()
    fun setView( view:NewsView)
}
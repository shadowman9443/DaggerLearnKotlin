package com.example.aunogarafat.daggerlearnkotlin.ui.homepage.View

import com.example.aunogarafat.daggerlearnkotlin.model.News

/**
 * Created by aunogarafat on 2/28/18.
 * Project name DaggerLearnKotlin
 */
interface NewsView {
    fun getNewsList(newsList:List<News>)

    fun init()

    fun loadFinish()

    fun showError()
}
package com.example.aunogarafat.daggerlearnkotlin.ui.homepage.presenter

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.example.aunogarafat.daggerlearnkotlin.application.DagerKotlinApplication
import com.example.aunogarafat.daggerlearnkotlin.model.News
import com.example.aunogarafat.daggerlearnkotlin.model.NewsResponse
import com.example.aunogarafat.daggerlearnkotlin.network.ApiInterface
import com.example.aunogarafat.daggerlearnkotlin.ui.homepage.View.NewsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject




/**
 * Created by aunogarafat on 2/28/18.
 * Project name DaggerLearnKotlin
 */
class NewsPresenterImpl @Inject constructor(private val context: Context):NewsPresenter{
    init{
        (context as DagerKotlinApplication).appComponent.inject(this)
    }

    @Inject
    lateinit var apiInterface: ApiInterface

    private lateinit var newsView: NewsView

    override fun setView(newsView: NewsView) {
        this.newsView = newsView
    }
    override fun getNews() {
        val call = apiInterface.getAnswers()
        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                newsView.init()
                val newsList:List<News>?
                newsList= response.body()!!.results
                newsView.getNewsList(newsList!!)
                newsView.loadFinish()

                Log.d(TAG, "Number of movies received: " + newsList.size)
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                // Log error here since request failed
                newsView.showError()
                newsView.loadFinish()
            }
        })
    }


}
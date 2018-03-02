package com.example.aunogarafat.daggerlearnkotlin.network

import com.example.aunogarafat.daggerlearnkotlin.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by aunogarafat on 2/27/18.
 * Project name DaggerLearnKotlin
 */
interface ApiInterface {
    @GET("v1/articles?source=google-news&sortBy=top&apiKey=a4ec074faab34f42bde4dbb899b75ae5")
    fun getAnswers(): Call<NewsResponse>
}
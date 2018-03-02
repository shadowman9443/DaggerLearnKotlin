package com.example.aunogarafat.daggerlearnkotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



/**
 * Created by aunogarafat on 2/28/18.
 * Project name DaggerLearnKotlin
 */
class ApiClient {
    companion object {
        private const val BASE_URL = "NAME_BASE_URL"
    }
    val BASE_URL = "https://newsapi.org/"

    private var retrofit: Retrofit? = null


    fun getClient(): Retrofit? {

        if (retrofit == null) {

            //without rxjava

            retrofit = Retrofit.Builder()

                    .baseUrl(BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())

                    .build()


        }

        return retrofit

    }
}
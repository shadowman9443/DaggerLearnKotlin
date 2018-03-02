package com.example.aunogarafat.daggerlearnkotlin.model

import com.google.gson.annotations.SerializedName

/**
 * Created by aunogarafat on 2/27/18.
 * Project name DaggerLearnKotlin
 */
data class NewsResponse (@field:SerializedName("status")
                         val status:String?,@field:SerializedName("source")
                         val source:String?,@field:SerializedName("sortBy")
                         val sortBy:String?,@field:SerializedName("articles")
                         val results:List<News>?){
}
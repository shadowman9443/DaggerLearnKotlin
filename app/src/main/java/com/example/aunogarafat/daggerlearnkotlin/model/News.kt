package com.example.aunogarafat.daggerlearnkotlin.model

import com.google.gson.annotations.SerializedName



/**
 * Created by aunogarafat on 2/27/18.
 * Project name DaggerLearnKotlin
 */


data class News(@field:SerializedName("author")
           var author: String?, @field:SerializedName("title")
           var title: String?, @field:SerializedName("description")
           var description: String?, @field:SerializedName("url")
           var url: String?, @field:SerializedName("urlToImage")
           var urlToImage: String?, @field:SerializedName("publishedAt")
           var publishedAt: String?)
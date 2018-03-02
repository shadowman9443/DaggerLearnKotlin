package com.example.aunogarafat.daggerlearnkotlin.ui.homepage.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.aunogarafat.daggerlearnkotlin.R
import com.example.aunogarafat.daggerlearnkotlin.model.News
import com.squareup.picasso.Picasso

/**
 * Created by aunogarafat on 2/28/18.
 * Project name DaggerLearnKotlin
 */
class NewsListAdapter(private val list:List<News>,private val context:Context) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder{
        val view=LayoutInflater.from(context).inflate(R.layout.news_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return  list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindViews(list[position])
    }

   inner class ViewHolder(intemview:View): RecyclerView.ViewHolder(intemview) {
       var title=itemView.findViewById(R.id.txtTile) as TextView
       var date=itemView.findViewById(R.id.txtDate) as TextView
       var des=itemView.findViewById(R.id.txtDescription) as TextView
       var newsmage=itemView.findViewById(R.id.newsImage) as ImageView
        fun bindViews(news:News){
            title.text=news.title
            date.text=news.publishedAt
            des.text=news.description
            if(!news.urlToImage.isNullOrEmpty()){
                Picasso.with(context).load(news.urlToImage).into(newsmage);
            }


        }
    }
}
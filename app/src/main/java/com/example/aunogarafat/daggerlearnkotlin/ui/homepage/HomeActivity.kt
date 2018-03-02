package com.example.aunogarafat.daggerlearnkotlin.ui.homepage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.aunogarafat.daggerlearnkotlin.R
import com.example.aunogarafat.daggerlearnkotlin.application.DagerKotlinApplication

import com.example.aunogarafat.daggerlearnkotlin.model.News
import com.example.aunogarafat.daggerlearnkotlin.ui.homepage.View.NewsView
import com.example.aunogarafat.daggerlearnkotlin.ui.homepage.adapter.NewsListAdapter
import com.example.aunogarafat.daggerlearnkotlin.ui.homepage.presenter.NewsPresenter
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), NewsView {
    var newsListAdapter: NewsListAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager?=null
    @Inject
    lateinit var presenter: NewsPresenter


    override fun getNewsList(newsList: List<News>) {
        newsListAdapter= NewsListAdapter(newsList!!,this)
        recycler_view.adapter=newsListAdapter
    }

    override fun init() {
        progress.post {
            progress.visibility = View.VISIBLE

        }
    }

    override fun loadFinish() {
        progress.post {
            progress.visibility = View.GONE

        }
    }

    override fun showError() {
        runOnUiThread {
           Toast.makeText(this,"Error is occured",Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as DagerKotlinApplication).appComponent.inject(this)
        presenter.setView(this)
        presenter.getNews()
        setContentView(R.layout.activity_home)
        recycler_view.layoutManager=layoutManager
        recycler_view.setLayoutManager( LinearLayoutManager(this));
        recycler_view.getLayoutManager().setMeasurementCacheEnabled(false);

    }
}

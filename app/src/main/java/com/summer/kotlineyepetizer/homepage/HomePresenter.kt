package com.summer.kotlineyepetizer.homepage

import com.google.gson.Gson
import com.summer.kotlineyepetizer.bean.Banner
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

open class HomePresenter(private var homeView: HomeContract.View) : HomeContract.Presenter {
    private val feed: String = "http://baobab.kaiyanapp.com/api/v2/feed"
    private val allRec: String = "http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=0"

    override fun destory() {
    }

    override fun getData() {
        doAsync {
            val url = URL(feed).readText()
            uiThread {
                var banner = Gson().fromJson(url, Banner::class.java)
                homeView.showData(banner)
            }

        }
    }

    override fun start() {
    }
}
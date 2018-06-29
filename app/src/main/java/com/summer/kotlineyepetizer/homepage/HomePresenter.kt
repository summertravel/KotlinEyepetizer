package com.summer.kotlineyepetizer.homepage

import com.google.gson.Gson
import com.summer.kotlineyepetizer.bean.Banner
import com.summer.kotlineyepetizer.bean.MaybeULike
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

open class HomePresenter(private var homeView: HomeContract.View) : HomeContract.Presenter {
    private val feed: String = "http://baobab.kaiyanapp.com/api/v2/feed"
    private val allRec: String = "http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=0&isTag=false"
    override fun destory() {
    }

    override fun getData() {
        doAsync {
            val url = URL(feed).readText()
            val urlallRec = URL(allRec).readText()
            uiThread {
                var banner = Gson().fromJson(url, Banner::class.java)
                var uLike = Gson().fromJson(urlallRec, MaybeULike::class.java)
                homeView.showData(banner, uLike)
            }
        }
    }

    override fun start() {
    }
}
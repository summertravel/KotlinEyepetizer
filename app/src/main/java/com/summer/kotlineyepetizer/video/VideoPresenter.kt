package com.summer.kotlineyepetizer.video

import com.google.gson.Gson
import com.summer.kotlineyepetizer.bean.Issue
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class VideoPresenter(val view: VideoContact.View, relatedId: String) : VideoContact.Presenter {

    val url: String = "http://baobab.kaiyanapp.com/api/v4/video/related?id=$relatedId"

    override fun getData() {
        doAsync {
            val json = URL(url).readText()
            val bean = Gson().fromJson(json, Issue::class.java)
            uiThread {
                view.showData(bean.itemList)
            }
        }


    }

    override fun start() {
    }

    override fun destory() {
    }
}
package com.summer.kotlineyepetizer.gaunzhu

import com.google.gson.Gson
import com.summer.kotlineyepetizer.bean.Guanzhu
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class GuanZhuPresenter(var view :GuanzhuContract.View):GuanzhuContract.Presenter {
    val url:String = "http://baobab.kaiyanapp.com/api/v5/community/tab/list"
    override fun getData() {
        doAsync {
            val text = URL(url).readText()
            uiThread {
                val bean = Gson().fromJson(text,Guanzhu::class.java)
                view.showData(bean.tabInfo.tabList)
            }
        }
    }

    override fun start() {
    }

    override fun destory() {
    }
}
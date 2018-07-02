package com.summer.kotlineyepetizer.message

import com.google.gson.Gson
import com.summer.kotlineyepetizer.bean.MessageBean
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MessagePresenter(val view:MessageContract.View):MessageContract.Presenter {
    val url :String = "http://baobab.kaiyanapp.com/api/v3/messages"
    override fun getData() {
        doAsync {
            val response = URL(url).readText()
            uiThread {
                val bean  = Gson().fromJson(response,MessageBean::class.java)
                view.showData(bean.messageList)
            }
        }
    }

    override fun start() {
    }

    override fun destory() {
    }
}
package com.summer.kotlineyepetizer.gaunzhu

import android.os.Build.VERSION_CODES.M
import com.google.gson.Gson
import com.summer.kotlineyepetizer.bean.DynamicInfoCardBean
import com.summer.kotlineyepetizer.bean.MaybeULike
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class GuanZhuListPresenter(val index: Int, var view: GuanzhuListContract.View, val url: String) : GuanzhuContract.Presenter {
    override fun getData() {
        doAsync {
            val text = URL(url).readText()
            uiThread {
                if (index == 0) {
                    val bean = Gson().fromJson(text, MaybeULike::class.java)
                    view.showData(bean.itemList)
                } else {
                    val bean = Gson().fromJson(text, DynamicInfoCardBean::class.java)
                    view.showDynamicInfoCardBeanData(bean.itemList)
                }

            }
        }
    }

    override fun start() {
    }

    override fun destory() {
    }
}
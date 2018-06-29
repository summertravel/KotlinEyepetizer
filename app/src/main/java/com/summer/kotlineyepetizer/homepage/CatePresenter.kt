package com.summer.kotlineyepetizer.homepage

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.summer.kotlineyepetizer.bean.CategoriesBean
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

open class CatePresenter(private var view: CateContract.View) : CateContract.Presenter {
    private val cate: String = "http://baobab.kaiyanapp.com/api/v4/categories"
    override fun destory() {
    }

    override fun getData() {
        doAsync {
            var url = URL(cate).readText()
            uiThread {
                var value = object : TypeToken<ArrayList<CategoriesBean>>(){}
                var dataList:ArrayList<CategoriesBean> = Gson().fromJson(url, value.type)
                view?.showData(dataList)
            }
        }
    }

    override fun start() {
    }
}
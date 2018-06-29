package com.summer.kotlineyepetizer.video

import com.summer.kotlineyepetizer.base.BasePresenter
import com.summer.kotlineyepetizer.base.BaseView
import com.summer.kotlineyepetizer.bean.Item

interface VideoContact {
    interface View : BaseView {
        fun showData(dataList: ArrayList<Item>)
    }

    interface Presenter : BasePresenter {
        fun getData()
    }
}
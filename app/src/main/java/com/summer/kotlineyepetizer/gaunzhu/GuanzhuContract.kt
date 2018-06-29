package com.summer.kotlineyepetizer.gaunzhu

import com.summer.kotlineyepetizer.base.BasePresenter
import com.summer.kotlineyepetizer.base.BaseView
import com.summer.kotlineyepetizer.bean.Guanzhu

interface GuanzhuContract {
    interface View : BaseView {
        fun showData(title: ArrayList<Guanzhu.TabInfo.Tab>)
    }

    interface Presenter : BasePresenter {
        fun getData()
    }

}
package com.summer.kotlineyepetizer.homepage

import com.summer.kotlineyepetizer.base.BasePresenter
import com.summer.kotlineyepetizer.base.BaseView
import com.summer.kotlineyepetizer.bean.Banner

interface HomeContract {
    interface View : BaseView {
        fun showData(bean: Banner)
    }

    interface Presenter : BasePresenter {
        fun getData()
    }


}

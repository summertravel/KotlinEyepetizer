package com.summer.kotlineyepetizer.homepage

import com.summer.kotlineyepetizer.base.BasePresenter
import com.summer.kotlineyepetizer.base.BaseView
import com.summer.kotlineyepetizer.bean.CategoriesBean

interface CateContract {
    interface View : BaseView {
        fun showData(bean: ArrayList<CategoriesBean>)
    }

    interface Presenter : BasePresenter {
        fun getData()
    }


}

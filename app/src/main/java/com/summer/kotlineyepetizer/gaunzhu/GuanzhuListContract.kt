package com.summer.kotlineyepetizer.gaunzhu

import com.summer.kotlineyepetizer.base.BasePresenter
import com.summer.kotlineyepetizer.base.BaseView
import com.summer.kotlineyepetizer.bean.DynamicInfoCardBean.Item
import com.summer.kotlineyepetizer.bean.MaybeULike

interface GuanzhuListContract {
    interface View : BaseView {
        fun showData(title: ArrayList<MaybeULike.Item>)
        fun showDynamicInfoCardBeanData(title: ArrayList<Item>)
    }

    interface Presenter : BasePresenter {
        fun getData()
    }

}
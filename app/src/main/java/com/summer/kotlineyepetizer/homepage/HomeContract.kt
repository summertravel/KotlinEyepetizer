package com.summer.kotlineyepetizer.homepage

import com.summer.kotlineyepetizer.base.BasePresenter
import com.summer.kotlineyepetizer.base.BaseView
import com.summer.kotlineyepetizer.bean.Banner
import com.summer.kotlineyepetizer.bean.MaybeULike

interface HomeContract {
    interface View : BaseView {
        fun showData(bean: Banner, uLike: MaybeULike)
    }

    interface Presenter : BasePresenter {
        fun getData()
    }


}

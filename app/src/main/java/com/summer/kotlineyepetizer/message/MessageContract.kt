package com.summer.kotlineyepetizer.message

import com.summer.kotlineyepetizer.base.BasePresenter
import com.summer.kotlineyepetizer.base.BaseView
import com.summer.kotlineyepetizer.bean.Message

interface MessageContract {
    interface View : BaseView {
        fun showData(dataList: ArrayList<Message>)
    }

    interface Presenter : BasePresenter {
        fun getData()
    }
}
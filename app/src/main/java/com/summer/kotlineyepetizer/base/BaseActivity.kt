package com.summer.kotlineyepetizer.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() ,BaseView{
    override fun showLoading(s: String) {

    }

    override fun dismissLoading() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
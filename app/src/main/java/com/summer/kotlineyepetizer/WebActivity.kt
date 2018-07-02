package com.summer.kotlineyepetizer

import android.os.Bundle
import com.summer.kotlineyepetizer.base.BaseActivity
import com.summer.kotlineyepetizer.config.Constant
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_web
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionUrl = intent.getStringExtra(Constant.DATA)
        webview.loadUrl(actionUrl)
    }
}
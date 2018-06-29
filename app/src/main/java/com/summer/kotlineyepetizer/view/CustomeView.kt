package com.summer.kotlineyepetizer.view

import android.content.Context
import android.widget.FrameLayout

abstract class CustomeView(context: Context):FrameLayout(context) {
    abstract fun setSelect(index:Int)
}
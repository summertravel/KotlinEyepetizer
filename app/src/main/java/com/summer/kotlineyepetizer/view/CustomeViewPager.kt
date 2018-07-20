package com.summer.kotlineyepetizer.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet

class CustomeViewPager(context: Context, attributeSet: AttributeSet) : ViewPager(context, attributeSet) {

    override fun setCurrentItem(item: Int) {
        setCurrentItem(item,false)
    }

}
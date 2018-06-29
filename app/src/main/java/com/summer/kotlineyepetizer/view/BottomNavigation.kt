package com.summer.kotlineyepetizer.view

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout

class BottomNavigation(context: Context) : LinearLayout(context) {
    init {
        orientation = LinearLayout.HORIZONTAL
    }

    fun addView(viewList: ArrayList<CustomeView>) {
        for (i in viewList.indices) {

            viewList[i].setOnClickListener { viewList[i].setSelect(i) }
            addView(viewList[i])
        }
    }


}
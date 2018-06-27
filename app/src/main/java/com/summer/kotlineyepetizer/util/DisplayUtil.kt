/*
 *
 *  *  Created on 2018/5/11.
 *  *  Created by open ability group.
 *  *  Copyright (c) open ability group All rights reserved.
 *
 */

package com.summer.kotlineyepetizer.util

import android.app.Activity
import android.app.ActivityGroup
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Point
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.Display
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView

import java.lang.reflect.Field


object DisplayUtil {
    // 状态栏高度
    private var mStatusHeight = -1
    // 屏幕像素点
    private val screenSize = Point()

    fun getDensity(context: Context): Float {
        val resources = context.resources
        val dm = resources.displayMetrics
        return dm.density
    }

    fun getDensityWdith(context: Context): Int {
        val resources = context.resources
        val dm = resources.displayMetrics
        return dm.widthPixels
    }

    fun getDensityHeight(context: Context): Int {
        val resources = context.resources
        val dm = resources.displayMetrics
        return dm.heightPixels
    }

    // 1.代码中设置setXXSize的都是px单位，都需要把布局中的dp，sp转成px才能使用

    /**
     * 根据手机分辨率从 px(像素) 单位 转成 dp
     */
    fun px2dip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * 根据手机分辨率从 dp 单位 转成 px(像素)
     */
    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    fun px2sp(context: Context, pxValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }

    fun getWidth(context: Context, liangbianjuli: Int, num: Int,
                 picjuli: Int): Int {
        // 屏幕宽度-两边的距离-图片中间的距离 除以列数
        return (getDensityWdith(context)
                - DisplayUtil.dip2px(context, liangbianjuli.toFloat()) * 2 - dip2px(
                context, picjuli.toFloat()) * (num - 1)) / num
    }

    fun getWidth(context: Context, num: Int,
                 jian: Int): Int {
        // 屏幕宽度-两边的距离-图片中间的距离 除以列数
        return (getDensityWdith(context) - DisplayUtil.dip2px(context, jian.toFloat())) / num * 2
    }

    fun getWidth(context: Context, percent: Int): Int {
        // 获取屏幕的高度
        return Integer.parseInt((getDensityWdith(context) * percent / 100).toString() + "")
    }

    fun getHeight(context: Context, fenmu: Int): Int {
        // 获取屏幕的高度
        return getDensityHeight(context) / fenmu
    }

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return mStatusHeight
     */
    fun getStatusHeight(context: Context): Int {
        if (mStatusHeight != -1) {
            return mStatusHeight
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return 0
        }
        try {
            val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                mStatusHeight = context.resources.getDimensionPixelSize(resourceId)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return mStatusHeight
    }

    // 获取状态栏高度
    fun getStatusBarHeight(context: Context): Int {
        if (mStatusHeight <= 0) {
            val frame = Rect()
            (context as Activity).window.decorView.getWindowVisibleDisplayFrame(frame)
            mStatusHeight = frame.top
        }
        if (mStatusHeight <= 0) {
            try {
                val c = Class.forName("com.android.internal.R\$dimen")
                val obj = c.newInstance()
                val field = c.getField("status_bar_height")
                val x = Integer.parseInt(field.get(obj).toString())
                mStatusHeight = context.resources.getDimensionPixelSize(x)

            } catch (e1: Exception) {
                e1.printStackTrace()
            }

        }
        return mStatusHeight
    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     *
     * @param activity
     * @return bp
     */
    fun snapShotWithoutStatusBar(activity: Activity): Bitmap? {
        val view = activity.window.decorView
        view.isDrawingCacheEnabled = true
        view.buildDrawingCache()
        val bmp = view.drawingCache ?: return null
        val frame = Rect()
        activity.window.decorView.getWindowVisibleDisplayFrame(frame)
        val statusBarHeight = frame.top
        val bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, bmp.width, bmp.height - statusBarHeight)
        view.destroyDrawingCache()
        view.isDrawingCacheEnabled = false

        return bp
    }

    /**
     * 获取actionbar的像素高度，默认使用android官方兼容包做actionbar兼容
     *
     * @return
     */
    fun getActionBarHeight(context: Context): Int {
        var actionBarHeight = 0
        if (context is AppCompatActivity && context.supportActionBar != null) {
            Log.d("isAppCompatActivity", "==AppCompatActivity")
            actionBarHeight = context.supportActionBar!!.height
        } else if (context is Activity && context.actionBar != null) {
            Log.d("isActivity", "==Activity")
            actionBarHeight = context.actionBar!!.height
        } else if (context is ActivityGroup) {
            Log.d("ActivityGroup", "==ActivityGroup")
            if (context.currentActivity is AppCompatActivity && (context.currentActivity as AppCompatActivity).supportActionBar != null) {
                actionBarHeight = (context.currentActivity as AppCompatActivity).supportActionBar!!.height
            } else if (context.currentActivity is Activity && (context.currentActivity as Activity).actionBar != null) {
                actionBarHeight = (context.currentActivity as Activity).actionBar!!.height
            }
        }
        if (actionBarHeight != 0)
            return actionBarHeight
        val tv = TypedValue()
        if (context.theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarSize, tv, true)) {
            if (context.theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarSize, tv, true))
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.resources.displayMetrics)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            if (context.theme.resolveAttribute(android.R.attr.actionBarSize, tv, true))
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.resources.displayMetrics)
        } else {
            if (context.theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarSize, tv, true))
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.resources.displayMetrics)
        }
        Log.d("actionBarHeight", "====$actionBarHeight")
        return actionBarHeight
    }


    /**
     * 设置view margin
     *
     * @param v
     * @param l
     * @param t
     * @param r
     * @param b
     */
    fun setMargins(v: View, l: Int, t: Int, r: Int, b: Int) {
        if (v.layoutParams is ViewGroup.MarginLayoutParams) {
            val p = v.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(l, t, r, b)
            v.requestLayout()
        }
    }

    /**
     * @param context
     * @param bgAlpha
     * @param isDialog
     */
    fun backgroundAlpha(context: Context, bgAlpha: Float, isDialog: Boolean) {
        val lp = (context as Activity).window.attributes
        if (isDialog)
            context.window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        lp.alpha = bgAlpha // 0.0-1.0
        context.window.attributes = lp
    }

    //设置左边图片
    fun setLeftImg(tv: TextView?, @DrawableRes imgId: Int) {
        tv?.setCompoundDrawablesWithIntrinsicBounds(imgId, 0, 0, 0)
    }

    fun setRightImg(tv: TextView?, @DrawableRes imgId: Int) {
        tv?.setCompoundDrawablesWithIntrinsicBounds(0, 0, imgId, 0)
    }

    fun setDrawbleLeft(context: Context, view: TextView, rsd: Int, demens: Int) {
        val drawable = ContextCompat.getDrawable(context, rsd)
        // / 这一步必须要做,否则不会显示.
        drawable!!.setBounds(0, 0, drawable.minimumWidth,
                drawable.minimumHeight)
        view.setCompoundDrawables(drawable, null, null, null)
        view.compoundDrawablePadding = dip2px(context, demens.toFloat())
    }

    fun setDrawbleRight(context: Context, view: TextView, rsd: Int, demens: Int) {
        val drawable = context.resources.getDrawable(rsd)
        // / 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.minimumWidth,
                drawable.minimumHeight)
        view.setCompoundDrawables(null, null, drawable, null)
        view.compoundDrawablePadding = demens
    }

    fun setDrawbleTop(context: Context, view: TextView, rsd: Int, demens: Int) {
        val drawable = context.resources.getDrawable(rsd)
        // / 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.minimumWidth,
                drawable.minimumHeight)
        view.setCompoundDrawables(null, drawable, null, null)
        view.compoundDrawablePadding = demens
    }

    fun getScreenSize(context: Activity?): Point {
        if (context == null) {
            return screenSize
        }
        val wm = context
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        if (wm != null) {
            val mDisplayMetrics = DisplayMetrics()
            val diplay = wm.defaultDisplay
            if (diplay != null) {
                diplay.getMetrics(mDisplayMetrics)
                val W = mDisplayMetrics.widthPixels
                val H = mDisplayMetrics.heightPixels
                if (W * H > 0 && (W > screenSize.x || H > screenSize.y)) {
                    screenSize.set(W, H)
                }
            }
        }
        return screenSize
    }
}

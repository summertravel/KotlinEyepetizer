package com.summer.kotlineyepetizer

import android.app.Application
import android.content.Context
import android.util.Log
import com.speedystone.greendaodemo.db.DaoMaster
import com.squareup.leakcanary.LeakCanary
import com.summer.kotlineyepetizer.bean.Account


class App : Application() {


    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
        val dataBase = object : DaoMaster.OpenHelper(this, ""){}.writableDb
        val daoSession = DaoMaster(dataBase).newSession()
        val accountDao = daoSession.accountDao
        val add = add()
        add.toString()
    }

    override fun onTrimMemory(level: Int) {
        GlideApp.get(this).trimMemory(level)
        Log.e("onTrimMemory","onTrimMemory")
        super.onTrimMemory(level)
    }

    override fun onLowMemory() {
        GlideApp.get(this).clearMemory()
        super.onLowMemory()
    }

    fun add():Int?{
        return 1
    }
}
package com.wzx.servicedemo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

/**
 * 描述：
 *
 * 创建人： Administrator
 * 创建时间： 2018/9/26
 * 更新时间：
 * 更新内容：
 */
class TestService : Service() {

    override fun onCreate() {
        super.onCreate()
        log("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        log("onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        log("onBind")
        return Binder()
    }

    override fun onDestroy() {
        log("onDestroy")
        super.onDestroy()
    }

    /**
     * 打印日志
     */
    private fun log(msg: String) {
        Log.i("TestService", msg)
    }
}
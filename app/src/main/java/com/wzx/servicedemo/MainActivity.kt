package com.wzx.servicedemo

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick

/**
 * 生命周期：
 * 从startService到stopService: onCreate->onStartCommand->onDestroy
 * 从bindSergvice到unbindService: onCreate->onBind->onDestroy
 *
 * 先startService，然后bindSergvice，销毁Service只是使用unbindService: onCreate->onStartCommand->onBind
 * 先bindSergvice，然后startService，销毁Service只是使用stopService: onCreate->onBind->onStartCommand
 */
class MainActivity : AppCompatActivity() {

    lateinit var connection: TestConnection

    class TestConnection : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        supportActionBar?.title = "会发生什么事情？"
        supportActionBar?.subtitle = "当startService和bindService都触发后"

        connection = TestConnection()
    }

    @OnClick(R.id.tv_start, R.id.tv_stop, R.id.tv_bind, R.id.tv_unbind)
    fun onViewsClick(view: View) {
        when (view.id) {
            R.id.tv_start -> {
                startService()
            }
            R.id.tv_stop -> {
                stopService()
            }
            R.id.tv_bind -> {
                bindService()
            }
            R.id.tv_unbind -> {
                unbindSerivce()
            }
            else -> {

            }
        }
    }

    fun startService() {
        startService(Intent(this, TestService::class.java))
    }

    fun stopService() {
        stopService(Intent(this, TestService::class.java))
    }

    fun bindService() {
        bindService(Intent(this, TestService::class.java), connection, BIND_AUTO_CREATE)
    }

    fun unbindSerivce() {
        unbindService(connection)
    }

    override fun onStop() {
        stopService()
        super.onStop()
    }
}

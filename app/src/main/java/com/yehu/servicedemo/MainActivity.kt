package com.yehu.servicedemo

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Konlit Code")
        setContentView(R.layout.activity_main)
    }

    fun startService(v: View) {
        Log.i(TAG, "startService()")
        startService(Intent(this, MyService::class.java))
//        startService(Intent(this, MyService.javaClass))// 启动无效
    }

    fun bindService(v: View) {
        Log.i(TAG, "bindService()")
        bindService(Intent(this, MyService::class.java), serviceConnent, Context.BIND_AUTO_CREATE)
    }

    fun stopService(v: View) {
        Log.i(TAG, "stopService()")
        stopService(Intent(this, MyService::class.java))
    }

    fun unbindService(v: View) {
        Log.i(TAG, "unbindService()")
        unbindService(serviceConnent)
    }

    fun startActivity(v: View){
        startActivity(Intent(this,Main2Activity::class.java))
    }

    val serviceConnent = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            Log.d(TAG, "Service connected " + i++)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            Log.i(TAG, "Service disconnected")
        }
    }

    companion object {
        val TAG = "Service"
        var i = 0;
    }
}

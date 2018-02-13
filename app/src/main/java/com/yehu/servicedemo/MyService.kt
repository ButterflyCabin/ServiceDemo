package com.yehu.servicedemo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.yehu.servicedemo.Event.FrontEvent
import de.greenrobot.event.EventBus

class MyService : Service() {

    class MyBinder : Binder() {
    }

    override fun onBind(intent: Intent): IBinder? {
        val msg = "onBind()"
        EventBus.getDefault().post(FrontEvent(TAG + msg))
        Log.i(MainActivity.TAG, msg)
        return MyBinder()
    }


    override fun onRebind(intent: Intent) {
        val msg = "onRebind()"
        EventBus.getDefault().post(FrontEvent(TAG + msg))
        Log.i(MainActivity.TAG, msg)
        super.onRebind(intent)
    }

    override fun onCreate() {
        val msg = "onCreate()"
        EventBus.getDefault().post(FrontEvent(TAG + msg))
        Log.i(MainActivity.TAG, msg)
        super.onCreate()
    }

    override fun onStart(intent: Intent, startId: Int) {
        val msg = "onStart()"
        EventBus.getDefault().post(FrontEvent(TAG + msg))
        Log.i(MainActivity.TAG, msg)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val msg = "onStartCommand()"
        EventBus.getDefault().post(FrontEvent(TAG + msg))
        Log.i(MainActivity.TAG, msg)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent): Boolean {
        val msg = "onUnbind()"
        EventBus.getDefault().post(FrontEvent(TAG + msg))
        Log.i(MainActivity.TAG, msg)
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        val msg = "onDestroy()"
        EventBus.getDefault().post(FrontEvent(TAG + msg))
        super.onDestroy()
    }

    companion object {
        val TAG = "MyService：\t"
    }
}

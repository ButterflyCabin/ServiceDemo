package com.yehu.servicedemo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    class MyBinder: Binder() {

    }

    override fun onBind(intent: Intent): IBinder? {
        Log.d(TAG, "onBind()")
        return MyBinder()
    }

    override fun onRebind(intent: Intent) {
        Log.d(TAG, "onRebind()")
        super.onRebind(intent)
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate()")
        super.onCreate()
    }

    override fun onStart(intent: Intent, startId: Int) {
        Log.d(TAG, "onStart()")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand()")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent): Boolean {
        Log.d(TAG, "onUnbind()")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy()")
        super.onDestroy()
    }

    companion object {
        val TAG = "Service "
    }
}

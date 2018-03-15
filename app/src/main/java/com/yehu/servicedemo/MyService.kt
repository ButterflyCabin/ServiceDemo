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
        EventBus.getDefault().post(FrontEvent(TAG , "onBind()"))
        return MyBinder()
    }


    override fun onRebind(intent: Intent) {
        EventBus.getDefault().post(FrontEvent(TAG , "onRebind()"))
        super.onRebind(intent)
    }

    override fun onCreate() {
        EventBus.getDefault().post(FrontEvent(TAG , "onCreate()"))
        super.onCreate()
    }

    override fun onStart(intent: Intent, startId: Int) {
        EventBus.getDefault().post(FrontEvent(TAG , "onStart()"))
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        EventBus.getDefault().post(FrontEvent(TAG , "onStartCommand()"))
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent): Boolean {
        EventBus.getDefault().post(FrontEvent(TAG , "onUnbind()"))
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().post(FrontEvent(TAG , "onDestroy()"))
    }

    companion object {
        val TAG = "My__Service：\t\t"
    }
}

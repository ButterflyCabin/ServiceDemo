package com.yehu.servicedemo

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import com.yehu.servicedemo.Event.FrontEvent
import de.greenrobot.event.EventBus
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var show_log: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
        setTitle("Konlit Code")
        setContentView(R.layout.activity_main)
        show_log = findViewById(R.id.show_log) as EditText;
    }

    fun startService(v: View) {
        showLog(TAG, "startService()")
        startService(Intent(this, MyService::class.java))
//        startService(Intent(this, MyService.javaClass))// 启动无效
    }

    fun bindService(v: View) {
        showLog(TAG, "bindService()")
        bindService(Intent(this, MyService::class.java), serviceConnent, Context.BIND_AUTO_CREATE)
    }

    fun stopService(v: View) {
        showLog(TAG, "stopService()")
        stopService(Intent(this, MyService::class.java))
    }

    fun unbindService(v: View) {
        try {
            unbindService(serviceConnent)
            showLog(TAG, "unbindService()")
        }catch (e: Exception){
            showLog(TAG, "not bindService")
        }


    }

    fun startActivity(v: View) {
        startActivity(Intent(this, Main2Activity::class.java))
    }

    val serviceConnent = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            showLog(TAG, "Service connected " + i++)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            showLog(TAG, "Service disconnected")
        }
    }

    fun clearLog(v: View) {
        show_log.setText("")
    }

    fun showLog(tag: String, msg: String) {
        show_log.append(tag + msg + "\n\r")
        Log.i(tag, msg)
        show_log.setSelection(show_log.text.length)
    }

    companion object {
        val TAG = "MainActivity：\t\t"
        var i = 0;
    }

    fun onEventMainThread(event: FrontEvent) {
        showLog(event?.tag, event?.msg)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }
}

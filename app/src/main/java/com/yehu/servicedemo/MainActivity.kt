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
import android.widget.TextView
import com.yehu.servicedemo.Event.FrontEvent
import de.greenrobot.event.EventBus

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
        val msg = "startService()"
        showLog(TAG + msg)
        Log.i(TAG, msg)
        startService(Intent(this, MyService::class.java))
//        startService(Intent(this, MyService.javaClass))// 启动无效
    }

    fun bindService(v: View) {
        val msg = "bindService()"
        showLog(TAG + msg)
        Log.i(TAG, msg)
        bindService(Intent(this, MyService::class.java), serviceConnent, Context.BIND_AUTO_CREATE)
    }

    fun stopService(v: View) {
        val msg = "stopService()"
        showLog(TAG + msg)
        Log.i(TAG, msg)
        stopService(Intent(this, MyService::class.java))
    }

    fun unbindService(v: View) {
        val msg = "unbindService()"
        showLog(TAG + msg)
        Log.i(TAG, msg)
        unbindService(serviceConnent)
    }

    fun startActivity(v: View) {
        startActivity(Intent(this, Main2Activity::class.java))
    }

    val serviceConnent = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            val msg = "Service connected " + i++
            showLog(TAG + msg)
            Log.i(TAG, msg)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            val msg = "Service disconnected"
            showLog(TAG + msg)
            Log.i(TAG, msg)
        }
    }
    fun clearLog(v:View){
        show_log.setText("")
    }

    fun showLog(msg: String) {
        show_log.append(msg + "\n\r")
        show_log.setSelection(show_log.text.length)
    }

    companion object {
        val TAG = "MainActivity: "
        var i = 0;
    }

    fun onEventMainThread(event: FrontEvent){
        showLog(event?.msg)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }
}

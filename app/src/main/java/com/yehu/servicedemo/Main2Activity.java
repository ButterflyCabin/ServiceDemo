package com.yehu.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yehu.servicedemo.Event.Front2Event;

import de.greenrobot.event.EventBus;

public class Main2Activity extends AppCompatActivity {
    public static final String TAG = "Main2Activity：\t";
    private TextView show_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Java Code");
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        setContentView(R.layout.activity_main2);
        show_log = (TextView) findViewById(R.id.show_log);
    }

    public void startService(View view) {
        showLog(TAG, "startService()");
        startService(new Intent(this, My2Service.class));
    }

    public void bindService(View v) {
        showLog(TAG, "bindService()");
        bindService(new Intent(this, My2Service.class), serviceConnent, Context.BIND_AUTO_CREATE);
    }

    public void stopService(View v) {
        showLog(TAG, "stopService()");
        stopService(new Intent(this, My2Service.class));
    }

    public void unbindService(View v) {
       try{
           unbindService(serviceConnent);
           showLog(TAG, "unbindService()");
       }catch (Exception e){
           showLog(TAG, "not bindService");
       }

    }

    public void startActivity(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }

    void showLog(String tag, String msg) {
        show_log.append(tag + msg + "\n\r");
        Log.i(tag, msg);
    }

    public void clearLog(View v) {
        show_log.setText("");
    }


    public static int i = 0;
    ServiceConnection serviceConnent = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            showLog(TAG, "Service connected " + i++);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            String msg = "Service Disconnected()";
            showLog(TAG, msg);
        }
    };

    public void onEventMainThread(Front2Event event) {
        if (null != event) {
            showLog(event.tag, event.msg);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}

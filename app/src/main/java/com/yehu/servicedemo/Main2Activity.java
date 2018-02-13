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
        String msg = "startService()";
        Log.i(TAG, msg);
        showLog(TAG + msg);
        startService(new Intent(this, My2Service.class));
    }

    public void bindService(View v) {
        String msg = "bindService()";
        Log.i(TAG, msg);
        showLog(TAG + msg);
        bindService(new Intent(this, My2Service.class), serviceConnent, Context.BIND_AUTO_CREATE);
    }

    public void stopService(View v) {
        String msg = "stopService()";
        Log.i(TAG, msg);
        showLog(TAG + msg);
        stopService(new Intent(this, My2Service.class));
    }

    public void unbindService(View v) {
        String msg = "unbindService()";
        Log.i(TAG, msg);
        showLog(TAG + msg);
        unbindService(serviceConnent);
    }

    public void startActivity(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }

    void showLog(String msg) {
        show_log.append(msg + "\n\r");
    }

    public void clearLog(View v) {
        show_log.setText("");
    }


    public static int i = 0;
    ServiceConnection serviceConnent = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            String msg = "Service connected " + i++;
            Log.i(TAG, msg);
            showLog(TAG + msg);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            String msg = "Service Disconnected()";
            Log.i(TAG, msg);
            showLog(TAG + msg);
        }
    };

    public void onEventMainThread(String msg){
        if (null != msg){
            showLog(msg);
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

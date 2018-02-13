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

public class Main2Activity extends AppCompatActivity {
    public static final String TAG = "Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Java Code");
        setContentView(R.layout.activity_main2);
    }

    public void startService(View view) {
        Log.i(TAG, "startService()");
        startService(new Intent(this, My2Service.class));
    }

    public void bindService(View v) {
        Log.i(TAG, "bindService()");
        bindService(new Intent(this, My2Service.class), serviceConnent, Context.BIND_AUTO_CREATE);
    }

    public void stopService(View v) {
        Log.i(TAG, "stopService()");
        stopService(new Intent(this, My2Service.class));
    }

    public void unbindService(View v) {
        Log.i(TAG, "unbindService()");
        unbindService(serviceConnent);
    }

    public void startActivity(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public static int i = 0;
    ServiceConnection serviceConnent = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "Service connected " + i++);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "Service disconnected");
        }
    };
}

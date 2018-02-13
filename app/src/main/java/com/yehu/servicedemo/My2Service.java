package com.yehu.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import de.greenrobot.event.EventBus;

public class My2Service extends Service {
    public static final String TAG = "My2Service ";
    public My2Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        String msg = "onBind()";
        EventBus.getDefault().post(TAG + msg);
        Log.d(TAG, msg);
        return null;
    }

    @Override
    public void onCreate() {
        String msg = "onCreate()";
        EventBus.getDefault().post(TAG + msg);
        Log.d(TAG, msg);
        super.onCreate();
    }

    @Override
    public void onRebind(Intent intent) {
        String msg = "onRebind()";
        EventBus.getDefault().post(TAG + msg);
        Log.d(TAG, msg);
        super.onRebind(intent);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        String msg = "onStart()";
        EventBus.getDefault().post(TAG + msg);
        Log.d(TAG, msg);
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String msg = "onStartCommand()";
        EventBus.getDefault().post(TAG + msg);
        Log.d(TAG, msg);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        String msg = "onUnbind()";
        EventBus.getDefault().post(TAG + msg);
        Log.d(TAG, msg);
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        String msg = "onDestroy()";
        EventBus.getDefault().post(TAG + msg);
        Log.d(TAG, msg);
        super.onDestroy();
    }
}

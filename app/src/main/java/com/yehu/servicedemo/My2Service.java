package com.yehu.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.yehu.servicedemo.Event.Front2Event;

import de.greenrobot.event.EventBus;

public class My2Service extends Service {
    public static final String TAG = "My_2_Service：\t";
    public My2Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        EventBus.getDefault().post(new Front2Event(TAG, "onBind()"));
        return null;
    }

    @Override
    public void onCreate() {
        EventBus.getDefault().post(new Front2Event(TAG, "onCreate()"));
        super.onCreate();
    }

    @Override
    public void onRebind(Intent intent) {
        EventBus.getDefault().post(new Front2Event(TAG, "onRebind()"));
        super.onRebind(intent);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        EventBus.getDefault().post(new Front2Event(TAG, "onStart()"));
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        EventBus.getDefault().post(new Front2Event(TAG, "onStartCommand()"));
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        EventBus.getDefault().post(new Front2Event(TAG, "onUnbind()"));
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().post(new Front2Event(TAG, "onDestroy()"));
    }
}

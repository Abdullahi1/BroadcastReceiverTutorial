package com.example.abdullahi.broadcastreceiver.tutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyFirstReceiver extends BroadcastReceiver {

    public static final String TAG = MyFirstReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Hello from 1st receiver");

    }
}

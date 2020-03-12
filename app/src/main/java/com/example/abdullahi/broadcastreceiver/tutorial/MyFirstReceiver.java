package com.example.abdullahi.broadcastreceiver.tutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyFirstReceiver extends BroadcastReceiver {

    public static final String TAG = MyFirstReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Hello from 1st receiver");
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age",0);
        Toast.makeText(context, "Hello from 1st receiver", Toast.LENGTH_LONG).show();

    }
}

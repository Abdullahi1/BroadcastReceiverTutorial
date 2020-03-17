package com.example.abdullahi.broadcastreceiver.tutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int a = intent.getIntExtra("a",4);
        int b = intent.getIntExtra("b",7);

        int sum = a + b;

        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(context);

        Intent returningIntent = new Intent("my.intent.action");
        returningIntent.putExtra("sum",sum);
        broadcastManager.sendBroadcast(intent);
    }
}

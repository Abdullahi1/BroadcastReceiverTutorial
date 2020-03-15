package com.example.abdullahi.broadcastreceiver.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private MyFirstReceiver firstReceiver;
    private TextView textView;
    private int ctr = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstReceiver = new MyFirstReceiver();
        textView = findViewById(R.id.tv_timer_val);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        registerReceiver(firstReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(firstReceiver);
    }

    public void unregisterReceiver(View view) {
        unregisterReceiver(timeTickReceiver);
    }

    public void registerReceiver(View view) {


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);

        registerReceiver(timeTickReceiver, intentFilter);
    }

    private BroadcastReceiver timeTickReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int minutes = ctr;
            textView.setText(minutes + " minute over");
            ctr++;

            Toast.makeText(context, "Hello Welcome to Time tick receiver", Toast.LENGTH_LONG).show();
        }
    };
}

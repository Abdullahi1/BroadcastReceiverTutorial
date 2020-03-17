package com.example.abdullahi.broadcastreceiver.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        Button button  = findViewById(R.id.bt_broad_cast);
        Button button1 = findViewById(R.id.bt_broad_cast_inner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFirstReceiver();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callThirdReceiver();
            }
        });
    }

    private void callFirstReceiver(){

    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction("my.intent.action");
        localBroadcastManager.registerReceiver(resultReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        localBroadcastManager.unregisterReceiver(resultReceiver);
    }

    private void callThirdReceiver(){
        Intent intent = new Intent(this, MyReceiver.class);
        intent.putExtra("a",34);
        intent.putExtra("b", 45);

        sendBroadcast(intent);

        Toast.makeText(this, "BroadCast Sent", Toast.LENGTH_SHORT).show();
    }

    private BroadcastReceiver resultReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int sum = intent.getIntExtra("sum",3);

            Toast.makeText(context, "Sum is = "+sum, Toast.LENGTH_SHORT).show();

        }
    };
}

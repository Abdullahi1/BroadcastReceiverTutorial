package com.example.abdullahi.broadcastreceiver.tutorial;

import androidx.appcompat.app.AppCompatActivity;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button  = findViewById(R.id.bt_broad_cast);
        Button button1 = findViewById(R.id.bt_broad_cast_inner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MyFirstReceiver.class);
//                sendBroadcast(intent);


//                Intent intent = new Intent("android.mycustom.action");
//                sendBroadcast(intent);

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
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        Intent intent = registerReceiver(null, intentFilter);
        
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        
        if (status == BatteryManager.BATTERY_STATUS_CHARGING){
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -200);
            Toast.makeText(this, "Battery Getting Charged\nLevel at "+level +"%", Toast.LENGTH_SHORT).show();

        }else if (status == BatteryManager.BATTERY_STATUS_DISCHARGING){
            Toast.makeText(this, "Battery is Discharging", Toast.LENGTH_SHORT).show();
        }else if (status ==  BatteryManager.BATTERY_STATUS_FULL){
            Toast.makeText(this, "Battery Fully Charged", Toast.LENGTH_SHORT).show();
        }
    }

    private void callThirdReceiver(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryStatusReceiver, intentFilter);
    }

    private BroadcastReceiver batteryStatusReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

            if (status == BatteryManager.BATTERY_STATUS_CHARGING){
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -200);
                Toast.makeText(context, "Battery Getting Charged\nLevel at "+level +"%", Toast.LENGTH_SHORT).show();

            }else if (status == BatteryManager.BATTERY_STATUS_DISCHARGING){
                Toast.makeText( context, "Battery is Discharging", Toast.LENGTH_SHORT).show();
            }else if (status ==  BatteryManager.BATTERY_STATUS_FULL){
                Toast.makeText(context, "Battery Fully Charged", Toast.LENGTH_SHORT).show();
            }

        }
    };


    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(batteryStatusReceiver);
    }
}

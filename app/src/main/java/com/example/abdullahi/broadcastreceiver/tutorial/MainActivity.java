package com.example.abdullahi.broadcastreceiver.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MyFirstReceiver.class);
//                sendBroadcast(intent);


                Intent intent = new Intent("android.mycustom.action");
                sendBroadcast(intent);

            }
        });
    }


    public static class MyThirdReceiverInner extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("TAG","Hello from 3rd receiver");
            Toast.makeText(context, "Hello from 3rd receiver", Toast.LENGTH_LONG).show();
        }
    }

    public static class MyFourthReceiverInner extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("TAG","Hello from 4th receiver");
            Toast.makeText(context, "Hello from 4th receiver", Toast.LENGTH_LONG).show();
        }
    }
}

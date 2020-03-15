package com.example.abdullahi.broadcastreceiver.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
        Intent intent = new Intent("android.mycustom.action");

        //Sending a data to a broadcast with intent
        intent.putExtra("name", "Abdulazeez Abdullahi");
        intent.putExtra("age", 12);

       // sendBroadcast(intent);
        sendOrderedBroadcast(intent, null); //To be called when sending an ordered broadcast
        sendOrderedBroadcast(intent, null, new MyFourthReceiverInner(),null, Activity.RESULT_OK,"Bold",null);
    }

    private void callThirdReceiver(){
        Intent intent = new Intent("android.mycustom.anotheraction");

        //Sending data to a broadcast through bundle
        Bundle bundle = new Bundle();
        bundle.putString("name", "Abdulazeez Abdullahi");
        bundle.putInt("age", 12);

        intent.putExtras(bundle);

        sendBroadcast(intent);
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

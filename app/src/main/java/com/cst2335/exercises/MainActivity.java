package com.cst2335.exercises;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        configureReceiver();
    }


    //In code Receiver registration
    private void configureReceiver() {

        IntentFilter filter = new IntentFilter();
        filter.addAction(MyReceiver.ACTION_OK_STR );
        receiver = new MyReceiver();

        registerReceiver(receiver, filter);
    }

    //unregister the broadcast receiver when it is no longer needed:
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

}
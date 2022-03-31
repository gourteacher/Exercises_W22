package com.cst2335.exercises;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    static private final String TAG = "MyReceiver";
    static final String ACTION_OK_STR = "com.cst2335.exercises.week12";

    public MyReceiver() {
    }

    //When the broadcast is received
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        Toast.makeText(context,
                "Broadcast Message Received",
                Toast.LENGTH_LONG).show();

    }
}
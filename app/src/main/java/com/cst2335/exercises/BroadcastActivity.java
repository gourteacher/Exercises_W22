package com.cst2335.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class BroadcastActivity extends AppCompatActivity {

    static private final String TAG = "BroadcastActivity";

    static private final String ACTION_OK_STR = "com.cst2335.exercises.week12";
    static private final String ACTION_BAD_STR = "com.cst2335.exercises";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);


        Button btn =  findViewById(R.id.send_broadcast);

        btn.setOnClickListener(view -> {
            send_broadcast(ACTION_OK_STR);
        } );


        Button other_btn =  findViewById(R.id.send_wrong_broadcast);
        other_btn.setOnClickListener(view -> {
            send_broadcast(ACTION_BAD_STR);
        } );

    }

    private void send_broadcast(String action) {

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.setAction(action);
        intent.putExtra("someData", 1000);
        sendBroadcast(intent);
    }
}
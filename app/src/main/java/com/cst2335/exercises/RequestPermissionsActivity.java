package com.cst2335.exercises;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Map;

public class RequestPermissionsActivity extends AppCompatActivity {

    public final static String TAG = "RequestPermissionsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_permissions);

        Button b = findViewById(R.id.permback);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "finish");
                finish();
            }
        });

        String[] permissions = {Manifest.permission.CAMERA,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_CONTACTS,
                                Manifest.permission.ANSWER_PHONE_CALLS,
                                Manifest.permission.CALL_PHONE,
                                Manifest.permission.INTERNET
                                };
        activityResultLauncher.launch(permissions);

        Log.i(TAG, "onCreate");

    }


    ActivityResultLauncher activityResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
        @Override
        public void onActivityResult(Map<String, Boolean> result) {

            Log.i(TAG, "onActivityResult");

            TextView userText = findViewById(R.id.result);
            String r = "";
            if (result.size() > 0) {
                for (String k : result.keySet()) {
                    String s  = k.substring("android.permission.".length());
                    r += s  + " : " + result.get(k) + "\n\n";
                }
                userText.setText(r);
            } else {

                userText.setText(" No permissions set");
            }
        }
    });
}
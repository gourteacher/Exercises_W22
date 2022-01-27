package com.cst2335.exercises;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override  
    //this is our starting point

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calls parent onCreate()
        setContentView( R.layout.activity_main ); //loads XML on screen

        CheckBox cb =  findViewById(R.id.check);

        RadioButton radio = findViewById(R.id.radio);
        SwitchCompat sw = findViewById(R.id.sw);

        sw.setOnCheckedChangeListener( ( btn, onOrOff) -> {
            radio.setChecked(onOrOff);

            Toast.makeText(MainActivity.this, "You clicked on switch", Toast.LENGTH_LONG).show();
        });


        cb.setOnCheckedChangeListener( ( b, c) -> {
            Toast.makeText(MainActivity.this, "You clicked on checkbox", Toast.LENGTH_SHORT).show();
            if(c)
                radio.setChecked(true);
            else
                radio.setChecked(false);
        });

    }
}
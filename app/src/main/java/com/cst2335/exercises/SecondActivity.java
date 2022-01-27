package com.cst2335.exercises;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent intent = getIntent(); //This gets you the object nextPage from FirstActivity.java
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);
        String typed = intent.getStringExtra("typed");

        Button previousButton = findViewById(R.id.previousPageButton);

        previousButton.setOnClickListener(click -> {

            finish();

        } );

    }
}
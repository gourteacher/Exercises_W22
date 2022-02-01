package com.cst2335.exercises;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    public final static String TAG ="FirstActivity";

    @Override     //first called
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calls parent onCreate()

        Log.i(TAG, "In onCreate, just creating the objects");
        setContentView( R.layout.activity_main ); //loads XML on screen

        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String previous = prefs.getString("USERINPUT", "NONE");

        EditText userText = findViewById(R.id.editText);

        Button btn = findViewById(R.id.start_button);
        btn.setOnClickListener(  (  click ) ->
        {
            String userTyped = userText.getText().toString();
            //Where you are     //where we're going
            Intent nextPage = new Intent(FirstActivity.this,   SecondActivity.class  );

            nextPage.putExtra("USERINPUT", userTyped);
            nextPage.putExtra("MONTH", 10);
            nextPage.putExtra("OTHER INFO", 3.14);

            //Make the transition:
            startActivity(nextPage);

        } ); //OnCLickListener goes in here


        Button btn2 = findViewById(R.id.intent_examples);
        btn2.setOnClickListener( (  click ) ->
        {
            Intent nextPage = new Intent(FirstActivity.this,   ActivityIntentExamples.class  );
            //Make the transition:
            startActivity(    nextPage  );
        }); //OnCLickListener goes in here
    }

    @Override //screen is visible but not responding
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "In onStart, visible but not responding");
    }

    @Override //screen is visible but not responding
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "In onResume");
    }

    @Override //screen is visible but not responding
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "In onPause");
    }

    @Override //not visible
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "In onStop");
    }

    @Override  //garbage collected
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "In onDestroy");
    }
}
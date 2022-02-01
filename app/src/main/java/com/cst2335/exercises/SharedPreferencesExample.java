package com.cst2335.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferencesExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_example);

        TextView editText = findViewById(R.id.pref_reserve_name);
        Button saveButton = findViewById(R.id.saveButton);

        SharedPreferences prefs = getSharedPreferences(FirstActivity.PREFERENCES_FILE, MODE_PRIVATE);
        String previous = prefs.getString("ReserveName", "Default Value");
        editText.setText( previous);

        Intent fromPrevious = getIntent();
        String input = fromPrevious.getStringExtra("USERINPUT"); //if "USERINPUT" is not found, return null
        int month = fromPrevious.getIntExtra("MONTH", 0); //if "MONTH" is not found, return 0
        double other = fromPrevious.getDoubleExtra("OTHER INFO", 0.0);//if "OTHERINFO" is not found, return 0.0

        EditText userInput = findViewById(R.id.pref_user_input);
        if ( !input.isEmpty()) {
            userInput.setText(input);
        }
        TextView tv1 = findViewById(R.id.pref_month);
        tv1.setText(Integer.toString(month));
        TextView tv2 = findViewById(R.id.pref_other_info);
        tv2.setText(Double.toString(other));

        saveButton.setOnClickListener(clk -> {
            SharedPreferences.Editor writer = prefs.edit();
            writer.putString("ReserveName", editText.getText().toString());
            writer.putString("USERINPUT", userInput.getText().toString());
            writer.putInt("MONTH", month);
            writer.putFloat("OTHER INFO", (float)other);

            writer.apply(); //save to disk
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener( clk ->
        {
            setResult(40, null);
            finish();
        });
    }
}
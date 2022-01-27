package com.cst2335.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SharedPreferencesExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_example);

        EditText editText = findViewById(R.id.userInput);

        Button saveButton = findViewById(R.id.saveButton);

        SharedPreferences prefs = getSharedPreferences("FileName", MODE_PRIVATE);
        String previous = prefs.getString("ReserveName", "Default Value");

        editText.setText(previous);

        saveButton.setOnClickListener(clk -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("ReserveName", editText.getText().toString());

            editor.commit();
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener( clk ->
        {
            setResult(40, null);
            finish();
        });
    }
}
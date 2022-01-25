package com.cst2335.exercises;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear); //shows the layout

        TextView myText = findViewById(R.id.text);//brings the textView from XML to Java
        myText.setText(R.string.hello_world);//nullPointer Exception

        EditText myEdit = findViewById(R.id.edit);
        RadioButton myCb = findViewById(R.id.myCb);

        Button myBtn = findViewById(R.id.btn);
        myBtn.setOnClickListener((vw) -> {
            myText.setText("You clicked the button!");
            myCb.setChecked(false);


            // Toast.makeText(MainActivity.this, " ",Toast.LENGTH_LONG).show();
            Snackbar.make(myText, "hello snack", Snackbar.LENGTH_LONG).show();
        });
        ImageButton myImgBtn = findViewById(R.id.imgView);

        myImgBtn.setOnClickListener((view) -> myEdit.setText("You clicked the image"));

        myCb.setOnCheckedChangeListener((btnView, onOrOff)-> {
            myBtn.setText(onOrOff?"box is on" : "box is off");

        });
    }
}
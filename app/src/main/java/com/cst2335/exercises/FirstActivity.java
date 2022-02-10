package com.cst2335.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FirstActivity extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.myListView);

        adapter = new ArrayAdapter<>( this,
                android.R.layout.simple_dropdown_item_1line,
                listItems);

        myListView.setAdapter(adapter);

        View.OnClickListener undo = view -> {
            listItems.remove(listItems.size() -1);
            adapter.notifyDataSetChanged();
            Snackbar.make(view, "Item removed", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        };

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            addListItem();
            Snackbar.make(view, "Item added to list",
                    Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
                    //.setAction("Undo", undo).show();
        });

    }

    private void addListItem() {
        SimpleDateFormat dateformat =
                new SimpleDateFormat("HH:mm:ss MM/dd/yyyy",
                        Locale.US);
        listItems.add(dateformat.format(new Date()));
        adapter.notifyDataSetChanged();
    }
}


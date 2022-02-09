package com.cst2335.exercises;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class FirstActivity extends AppCompatActivity {
    private ArrayList<String> elements = new ArrayList<>( Arrays.asList( "One", "Two", "Three" ) );
    MyListAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Your program starts here
        super.onCreate(savedInstanceState);

        // setContentView loads objects onto the screen.
        // Before this function, the screen is empty.
        setContentView(R.layout.activity_main);

        ListView myList = findViewById(R.id.theListView);
        //Line 37 is the same as lines 35 and 36:
        //ListAdapter myAdapter = new MyListAdapter();
        //myList.setAdapter( myAdapter);
        myList.setAdapter( myAdapter = new MyListAdapter());

        myList.setOnItemClickListener ( ( parent, view, pos, id) -> {
            elements.remove(pos);
            myAdapter.notifyDataSetChanged();
        })  ;

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener( click -> {
            elements.add("Hi");
            myAdapter.notifyDataSetChanged();
        });

        myList.setOnItemLongClickListener( (p, b, pos, id) -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("A title")

                    //What is the message:
                    .setMessage("Do you want to add stuff")

                    //what the Yes button does:
                    .setPositiveButton("Yes", (click, arg) -> {
                        elements.add("HELLO");
                        myAdapter.notifyDataSetChanged();
                    })
                    //What the No button does:
                    .setNegativeButton("No", (click, arg) -> { })

                    //An optional third button:
                    .setNeutralButton("Maybe", (click, arg) -> {  })

                    //You can add extra layout elements:
                    .setView(getLayoutInflater().inflate(R.layout.row_layout, null) )

                    //Show the dialog
                    .create().show();
            return true;
        });

        //Whenever you swipe down on the list, do something:
        SwipeRefreshLayout refresher = findViewById(R.id.refresher);
        refresher.setOnRefreshListener( () -> refresher.setRefreshing(false)  );
    }

    private class MyListAdapter extends BaseAdapter {

        public int getCount() { return elements.size();}

        public Object getItem(int position) { return "This is row " + position; }

        public long getItemId(int position) { return (long) position; }

        public View getView(int position, View old, ViewGroup parent)
        {
            LayoutInflater inflater = getLayoutInflater();

            //make a new row:
            View newView = inflater.inflate(R.layout.row_layout, parent, false);

            //set what the text should be for this row:
            TextView tView = newView.findViewById(R.id.textGoesHere);
            tView.setText( getItem(position).toString() );

            //return it to be put in the table
            return newView;
        }
    }
}


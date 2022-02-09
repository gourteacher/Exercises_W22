package com.cst2335.exercises;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> elements = new ArrayList<>(  );
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

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener( click -> {

            Log.i(TAG, "Adding a row");
            elements.add( "Another Row");
            myAdapter.notifyDataSetChanged();
        });

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                elements.remove(i);
                myAdapter.notifyDataSetChanged();
            }
        });




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

            //Button b =  newView.findViewById(R.id.textGoesHere);
            //b.setText( getItem(position).toString() );

            //return it to be put in the table
            return newView;
        }
    }
}


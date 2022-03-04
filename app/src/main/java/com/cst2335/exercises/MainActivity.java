package com.cst2335.exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHTTPRequest req = new MyHTTPRequest();
        req.execute("http://torunski.ca/CST2335_XML.xml");  //Type 1
    }
                                                //Type1     Type2   Type3
    private class MyHTTPRequest extends AsyncTask< String, Integer, String>
    {
               //Type3                Type1
        public String doInBackground(String ... args)
        {
            return "Done";
        }

        //Type 2
        public void onProgressUpdate(Integer ... args)
        {

        }
                                //Type3
        public void onPostExecute(String fromDoInBackground)
        {
            Log.i("HTTP", fromDoInBackground);
        }
    }
}
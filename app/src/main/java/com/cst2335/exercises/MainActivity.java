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

        new MyTask().execute("This is MyTask parameter");
    }


    //Type1     Type2   Type3
    private class MyTask extends AsyncTask< String, Integer, String>
    {
        static private final String TAG = "MyTask";

        //Type3                Type1
        @Override
        public String doInBackground(String ... args)
        {
            try {

                //create a URL object of what server to contact:
                String myString = args[0];

                publishProgress(25);
                Thread.sleep(1000);
                publishProgress(50);
                Thread.sleep(1000);
                publishProgress(75);

            }
            catch (Exception e)
            {

            }

            return "Done";
        }

        //Type 2
        public void onProgressUpdate(Integer ... args)
        {
            Log.i(TAG, "onProgressUpdate");
        }
        //Type3
        public void onPostExecute(String fromDoInBackground)
        {
            Log.i(TAG, fromDoInBackground);
        }
    }
}
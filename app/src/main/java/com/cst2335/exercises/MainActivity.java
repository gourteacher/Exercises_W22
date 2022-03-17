package com.cst2335.exercises;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tv;
    AsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startbtn = findViewById( R.id.startId);

        tv = findViewById(R.id.textViewId);

        Button cancelbtn = findViewById( R.id.cancel);


        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = new MyTask().execute();
        }});

        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.cancel(true);


            }});

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

                    int i = 0;
                    while (i <= 20) {
                        try {
                            Thread.sleep(1000);
                            i++;
                            publishProgress(i);
                        }
                        catch (Exception e) {
                        }
                    }

            }
            catch (Exception e)
            {

            }
            return "Activity Done";
        }

        //Type 2
        public void onProgressUpdate(Integer ... args)
        {

            Log.i(TAG, "onProgressUpdate " + args[0] );
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);

            Log.i(TAG, "onProgressUpdate " + s  );

            tv.setText(s);
        }

        //Type3
        public void onPostExecute(String fromDoInBackground)
        {

            Log.i(TAG, fromDoInBackground);

            tv.setText(fromDoInBackground);

        }

    }
}
package com.cst2335.exercises;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ChatRoom extends AppCompatActivity {

    static private final String TAG = "ChatRoom";

    boolean isTablet = false;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate");

        setContentView(R.layout.empty_layout); //loads the FrameLayouts

        isTablet = findViewById(R.id.detailsRoom) != null; //find the green FrameLayout

        if (savedInstanceState == null) {
            MessageListFragment chatFragment = new MessageListFragment();//create fragment object
            //load XML just a FrameLayout for loading fragments:

            FragmentManager fMgr = getSupportFragmentManager();

            FragmentTransaction tx = fMgr.beginTransaction();

            //load the fragment:
            tx.add(R.id.fragmentRoom, chatFragment);//load chatFragment into FrameLayout with id fragmentRoom
            tx.addToBackStack(null); //undo the fragmentTransaction instead of startActivity()
            tx.commit(); // now load it
        }
    }

    public void userClickedMessage(MessageListFragment.Message message, int position) {

        MessageDetailFragment details = new MessageDetailFragment(message, position);

        if(isTablet)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.detailsRoom, details ).commit(); // now load it
        }
        else //this is a phone
        {
            FragmentManager fMgr = getSupportFragmentManager();

            FragmentTransaction tx = fMgr.beginTransaction();

            //load the fragment:
            tx.add(R.id.fragmentRoom, details );//load chatFragment into FrameLayout with id fragmentRoom
            tx.addToBackStack( null ); //undo the fragmentTransaction instead of startActivity()
            tx.commit();
        }

    }

    @Override
    public void onStart () {
        super.onStart();
        Log.i(TAG, "onStart");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onRestoreInstanceState(Bundle b) {
        super.onRestoreInstanceState(b);
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle b) {
        super.onSaveInstanceState(b);
        Log.i(TAG, "onDestroy");
    }

}

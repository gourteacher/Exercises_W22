package com.cst2335.exercises;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class MessageDetailFragment extends Fragment {

    static private final String TAG = "MessageDetailFragment";

    TextView tv;

    MessageListFragment.Message chosenMessage;
    int position;

    public MessageDetailFragment(MessageListFragment.Message clicked, int pos){
        chosenMessage=clicked;
        position=pos;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //load the layout:
        Log.i(TAG, "onCreateView");

        View detailsLayout = inflater.inflate(R.layout.detail_layout, container, false);
        tv = detailsLayout.findViewById(R.id.textView);

        tv.setText("Message: "+ chosenMessage.getMessageTyped());

        return detailsLayout;//return what was inflated
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
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
    public void onAttach(Context c) {
        super.onAttach(c);
        Log.i(TAG, "onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach");
    }

    @Override
    public void onViewCreated(View v, Bundle b) {
        super.onViewCreated(v, b);
        Log.i(TAG, "onViewCreated");
    }
}
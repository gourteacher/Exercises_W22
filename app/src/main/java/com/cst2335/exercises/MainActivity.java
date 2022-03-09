package com.cst2335.exercises;


import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements MessageListFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_layout);

        if (savedInstanceState == null) {
            // Instance of first fragment
            MessageListFragment firstFragment = new MessageListFragment();

            // Add Fragment to FrameLayout (flContainer), using FragmentManager
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
            ft.setReorderingAllowed(true);
            ft.add(R.id.flContainer, firstFragment);    // add    Fragment
            ft.commit();     // commit FragmentTransaction

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                MessageDetailFragment secondFragment = new MessageDetailFragment();
                Bundle args = new Bundle();
                args.putInt("position", 0);
                secondFragment.setArguments(args);  // Communicate with Fragment using Bundle
                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                ft2.setReorderingAllowed(true);
                ft2.add(R.id.flContainer2, secondFragment);
                ft2.commit();
            }
        }
    }

    @Override
    public void onMessageItemSelected(int position) {
        Toast.makeText(this, "Called By Fragment A: position - "+ position, Toast.LENGTH_SHORT).show();

        // Load Detail Fragment
        MessageDetailFragment secondFragment = new MessageDetailFragment();

        Bundle args = new Bundle();
        args.putInt("position", position);
        secondFragment.setArguments(args); // (1) Communicate with Fragment using Bundle

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.flContainer2, secondFragment)
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.flContainer, secondFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}

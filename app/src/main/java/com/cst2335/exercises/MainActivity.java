package com.cst2335.exercises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.cst2335.exercises.fragments.InfoEntryFragment;
import com.cst2335.exercises.utils.EmailValidator;

public class MainActivity extends AppCompatActivity {

    // Logger for this class.
    private static final String TAG = "MainActivity";

    // The input field where the user enters his name.
    private EditText mNameText;
    // The input field where the user enters his email.
    private EditText mEmailText;
    // The validator for the email input field.
    private EmailValidator mEmailValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // Add Fragment to FrameLayout (flContainer), using FragmentManager
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
            ft.add(R.id.flContainer, InfoEntryFragment.newInstance());                                // add    Fragment
            ft.commit();                                                            // commit FragmentTransaction
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater infl = getMenuInflater();

        infl.inflate(R.menu.main_menu, menu );
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.increaseFontId) {
            Toast.makeText(this, "Increase font size", Toast.LENGTH_SHORT);
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.cst2335.exercises.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cst2335.exercises.utils.EmailValidator;
import com.cst2335.exercises.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoEntryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoEntryFragment extends Fragment {

    // Logger for this class.
    private static final String TAG = "EmailEntryFragment";

    // The input field where the user enters his email.
    private EditText mEmailText;
    // The validator for the email input field.
    private EmailValidator mEmailValidator;

    private EditText mNameText;


    public InfoEntryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment EmailEntryFragment.
     */
    public static InfoEntryFragment newInstance() {
        InfoEntryFragment fragment = new InfoEntryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fView =  inflater.inflate(R.layout.fragment_info_entry, container, false);

        Button saveButton = fView.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(view -> onSaveClick(view));

        mEmailText = (EditText) fView.findViewById(R.id.inputEmailId);
        mNameText = (EditText) fView.findViewById(R.id.inputNameId);

        // Setup field validators.
        mEmailValidator = new EmailValidator();
        mEmailText.addTextChangedListener(mEmailValidator);


        return fView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mEmailText.setText("");
    }

    /**
     * Called when the "Save" button is clicked.
     */
    public void onSaveClick(View view) {
        boolean fValidInput=true;
        // Don't save if the fields do not validate.
        if (!mEmailValidator.isValid()) {
            mEmailText.setError("Invalid email address");
            Log.w(TAG, "Invalid email entered.");
            fValidInput=false;
        }
        if (mNameText.getText().toString().isEmpty() ) {
            mNameText.setError("Enter a valid name here");
            Toast.makeText(getActivity(),  "Please enter a name", Toast.LENGTH_SHORT).show();
            fValidInput=false;
        }
        if (fValidInput) {

            if (getParentFragmentManager() != null) {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.flContainer, SaveInfoFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }

}
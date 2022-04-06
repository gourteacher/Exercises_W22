package com.cst2335.exercises.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cst2335.exercises.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SaveInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaveInfoFragment extends Fragment {

    public SaveInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment
     * @return A new instance of fragment SaveEmailFragment.
     */

    public static SaveInfoFragment newInstance() {
        SaveInfoFragment fragment = new SaveInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fView =  inflater.inflate(R.layout.fragment_save_info, container, false);

        return fView;
    }
}
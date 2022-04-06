package com.cst2335.exercises.sharedpreferences;

import java.util.Calendar;
/**
 * Model class containing personal information that will be saved to SharedPreferences.
 */
public class SharedPreferenceEntry {
    // Name of the user.
    private final String mName;

    // Email address of the user.
    private final String mEmail;
    public SharedPreferenceEntry(String name, String email) {
        mName = name;
        mEmail = email;
    }
    public String getName() {
        return mName;
    }
    public String getEmail() {
        return mEmail;
    }
}
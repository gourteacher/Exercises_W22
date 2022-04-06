package com.cst2335.exercises.sharedpreferences;

import android.content.SharedPreferences;

import com.cst2335.exercises.sharedpreferences.SharedPreferenceEntry;

/**
 *  Helper class to manage access to {@link SharedPreferences}.
 */
public class SharedPreferencesHelper {
    // Keys for saving values in SharedPreferences.
    static public final String KEY_NAME = "key_name";
    static public final String KEY_EMAIL = "key_email";
    // The injected SharedPreferences implementation to use for persistence.
    private final SharedPreferences mSharedPreferences;
    /**
     * Constructor with dependency injection.
     *
     * @param sharedPreferences The {@link SharedPreferences} that will be used in this DAO.
     */
    public SharedPreferencesHelper(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }
    /**
     * Saves the given {@link SharedPreferenceEntry} that contains the user's settings to
     * {@link SharedPreferences}.
     *
     * @param sharedPreferenceEntry contains data to save to {@link SharedPreferences}.
     * @return {@code true} if writing to {@link SharedPreferences} succeeded. {@code false}
     *         otherwise.
     */
    public boolean savePersonalInfo(SharedPreferenceEntry sharedPreferenceEntry){
        // Start a SharedPreferences transaction.
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_NAME, sharedPreferenceEntry.getName());
        editor.putString(KEY_EMAIL, sharedPreferenceEntry.getEmail());
        // Commit changes to SharedPreferences.
        return editor.commit();
    }
    /**
     * Retrieves the {@link SharedPreferenceEntry} containing the user's personal information from
     * {@link SharedPreferences}.
     *
     * @return the Retrieved {@link SharedPreferenceEntry}.
     */
    public SharedPreferenceEntry getPersonalInfo() {
        // Get data from the SharedPreferences.
        String name = mSharedPreferences.getString(KEY_NAME, "");

        String email = mSharedPreferences.getString(KEY_EMAIL, "");
        // Create and fill a SharedPreferenceEntry model object.
        return new SharedPreferenceEntry(name, email);
    }
}
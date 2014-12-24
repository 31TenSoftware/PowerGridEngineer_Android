package com.thirtyonetensoftware.android.powergridengineer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.thirtyonetensoftware.android.powergridengineer.R;
import com.thirtyonetensoftware.android.powergridengineer.fragment.MainFragment;
import com.thirtyonetensoftware.android.powergridengineer.fragment.PreferencesFragment;

/**
 * MainActivity
 * <p/>
 * Power Grid Engineer
 * 31Ten Software
 * <p/>
 * Author: Josh Kendrick
 */
public class MainActivity extends Activity implements MainFragment.OnPreferencesSelectedListener {

    private static final String MAIN_FRAGMENT_KEY = "main_fragment_key";

    private static final String PREFERENCES_FRAGMENT_KEY = "preferences_fragment_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        if ( savedInstanceState == null ) {
            getFragmentManager().beginTransaction().replace(R.id.container, new MainFragment(),
                                                            MAIN_FRAGMENT_KEY).commit();
        }
    }

    @Override
    public void onPreferencesSelected() {
        getFragmentManager().beginTransaction().replace(R.id.container,
                                                        new PreferencesFragment(), PREFERENCES_FRAGMENT_KEY).addToBackStack(null).commit();
    }
}
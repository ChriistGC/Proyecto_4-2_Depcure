package com.example.depcure.Preferences;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import com.example.depcure.R;

/** Configures still image demo settings. */
public class StillImagePreferenceFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_still_image);
        FaceDetectionUtils.setUpFaceDetectionPreferences(this, /* isStreamMode = */false);
    }
}

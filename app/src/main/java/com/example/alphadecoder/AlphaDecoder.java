package com.example.alphadecoder;

import android.app.Application;

import com.example.alphadecoder.utils.Preferences;

/**
 * Created by  on 04/01/22.
 */
public class AlphaDecoder extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.initialize(getApplicationContext());
    }
}

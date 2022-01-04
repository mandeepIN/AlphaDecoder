package com.example.alphadecoder.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class Preferences {
    private static String TAG = "ABPr";

    private static SharedPreferences sharedPreferences = null;
    private static final String PREF_IS_MOTHER_TONGUE_SELECTED = "isMotherTongueSelected";
    private static final String PREF_SELECTED_MOTHER_TONGUE = "selectedMotherTongue";
    private static final String PREFERENCE_NAME = "com.mofirst.playstore";

    public static void initialize(Context context) {
        if (sharedPreferences == null) {
            if (context.getApplicationContext() != null) {
                try {
                    sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCE_NAME, 0);
                } catch (Exception e) {
                    Log.e(TAG, "Exception initialize: " + e.getMessage(), e);
                }
            } else {
                sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, 0);
            }
        }
    }

    public static void setMotherTongueSelectedByUser(boolean languageSelected) {
        sharedPreferences.edit().putBoolean(PREF_IS_MOTHER_TONGUE_SELECTED, languageSelected).commit();
    }

    public static String getMotherTongue() {
        return Utils.getLangWithoutCountryCode(sharedPreferences.getString(PREF_SELECTED_MOTHER_TONGUE, "hi"));
    }

    public static void setMotherTongue(String language) {
        sharedPreferences.edit().putString(PREF_SELECTED_MOTHER_TONGUE, language).commit();
    }

}

package com.example.alphadecoder.utils;

/**
 * Created by kanchan on 04/01/22.
 */
public class Utils {

    public static String getLangWithoutCountryCode(String language) {
        int iend = language.indexOf('-');
        String formattedLang;
        if (iend != -1)
            formattedLang = language.substring(0, iend);
        else
            formattedLang = language;
        return formattedLang;
    }
}

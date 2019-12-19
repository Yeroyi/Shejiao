package com.example.hongligs.fragment;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtils {

    public static boolean Lei1(Context context, String fileName, String key, boolean value) {
        SharedPreferences settings = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }


    public static boolean getBoolean(Context context, String fileName, String key) {
        return getBoolean(context, fileName, key, false);
    }


    public static boolean getBoolean(Context context, String fileName, String key, boolean defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return settings.getBoolean(key, defaultValue);


    }
}

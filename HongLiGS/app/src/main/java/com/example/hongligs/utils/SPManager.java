package com.example.hongligs.utils;

import android.content.Context;

public class SPManager {


    public static String getUid(Context context) {
        return context.getSharedPreferences("uid", Context.MODE_PRIVATE).getString("uid", "");
    }

    public static void setUid(Context context, String uid) {
        context.getSharedPreferences("uid", Context.MODE_PRIVATE).edit().putString("uid", uid).commit();
    }


    /**
     * 是否第一次进入程序
     *
     * @param context
     * @param defult
     * @return
     */
    public static boolean isFirst(Context context, boolean defult) {
        return context.getSharedPreferences("isFrist", Context.MODE_PRIVATE).getBoolean("isFrist", defult);
    }

    public static void setIsFirst(Context context, boolean state) {
        context.getSharedPreferences("isFrist", Context.MODE_PRIVATE).edit().putBoolean("isFrist", state).commit();
    }

    //  是否第一次进入app
    public static Boolean getSyIsFirst(Context context) {
        return context.getSharedPreferences("isfirst", Context.MODE_PRIVATE).getBoolean("isfirst", false);
    }

    public static void setSyIsFirst(Context context, Boolean orderid) {
        context.getSharedPreferences("isfirst", Context.MODE_PRIVATE).edit().putBoolean("isfirst", orderid).commit();
    }
    // 选择男女
    public static String getChoice(Context context) {
        return context.getSharedPreferences("choice", Context.MODE_PRIVATE).getString("choice", "");
    }

    public static void setChoice(Context context, String choice) {
        context.getSharedPreferences("choice", Context.MODE_PRIVATE).edit().putString("choice", choice).commit();
    }


}

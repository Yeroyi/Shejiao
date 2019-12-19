package com.example.hongligs.bean;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreUtil {

    private static SharedPreferences sp;

    /** 保存数据 **/
    public static void saveBoolean(Context ctx, String key, boolean value) {
        if (sp == null) {
            sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    /** 取出数据 **/
    public static Boolean getBoolean(Context ctx, String key, boolean defValue) {
        if (sp == null) {
            sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    public interface ConstantValue {

        public static String ISFIRST = "isFirst";//全局静态变量
    }
}

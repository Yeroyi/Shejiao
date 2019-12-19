package com.example.hongligs.http;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Time:  2019/11/15
 * 创建者:  @hongwei
 * 邮  箱:  jhw505501898@163.com
 * 描  述:  网络连接
 */
public class NetUtil {
    private NetUtil() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 判断网络是否连接
     * ConnectivityManager 网络连接管理器
     * Class that answers queries about the state of network connectivity. It also notifies
     * applications when network connectivity changes. Get an instance of this class by
     * calling Context.getSystemService(Context.CONNECTIVITY_SERVICE).
     * (这个类被用来检查网络的连通性,可用性.当网络状态改变时,它将会通知app.
     * 可以通过Context.getSystemService(Context.CONNECTIVITY_SERVICE)拿到它的实例)
     * <p>
     * The primary responsibilities of this class are to:
     * (这个类的主要责任是:)
     * 1.Monitor network connections (Wi-Fi, GPRS, UMTS, etc.)
     * 监视网络连接状态
     * 2.Send broadcast intents when network connectivity changes
     * 当网络连接发生改变时,发送广播
     * 3.Attempt to "fail over" to another network when connectivity to a network is lost
     * 当某一个网络失效时,尝试连接其他的网络
     * 4.Provide an API that allows applications to query the coarse-grained or fine-grained state of the available networks
     * 提供一些api来允许app查询各种可用网络
     * 5.Provide an API that allows applications to request and select networks for their data traffic
     * 提供一些api来允许app请求和改变所连接的网络
     *
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {


        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (null != connectivity) {

            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否是wifi连接
     */
    public static boolean isWifi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetworkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetworkInfo.isConnected()) {
            return true;
        }

        return false;
    }

    /**
     * 打开网络设置界面
     */
    public static void openSetting(Activity activity) {
        Intent intent = new Intent("/");
        ComponentName cm = new ComponentName("com.android.settings",
                "com.android.settings.WirelessSettings");
        intent.setComponent(cm);
        intent.setAction("android.intent.action.VIEW");
        activity.startActivityForResult(intent, 0);
    }
}
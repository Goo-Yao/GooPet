package com.rdc.goospet.utils;

import android.util.Log;

/**
 * Created by Goo on 2016-8-28.
 * Log 工具类
 */
public class LogUtils {
    private final static String TAG = "Goo's Pet";
    private static boolean isShowLog = true;

    public static void e(String msg) {
        if (isShowLog) {
            Log.e(TAG, msg);
        }
    }

    public static void i(String msg) {
        if (isShowLog) {
            Log.i(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (isShowLog) {
            Log.d(TAG, msg);
        }
    }

    public static void v(String msg) {
        if (isShowLog) {
            Log.v(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (isShowLog) {
            Log.wtf(TAG, msg);
        }
    }
}

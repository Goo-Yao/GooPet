package com.rdc.goospet.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Goo on 2016-9-6.
 * Toast 工具类
 */
public class ToastUtil {
    private static Toast mToast = null;

    public static void showToast(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setText(text);
        }
        mToast.show();
    }
}

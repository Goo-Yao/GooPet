package com.rdc.goospet.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 * Created by Goo on 2016-9-6.
 * 对话框工具类
 */
public class DialogUtils {
    public static AlertDialog showCoustomDialog(Context context, View dialog, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setView(dialog);
        return builder.show();
    }
}

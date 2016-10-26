package com.rdc.goospet.utils;

import android.content.Context;

/**
 * 尺寸工具类
 * Created by Goo on 2016-10-24.
 */

public class DimenUtils {
    /**
     * dp -> px
     *
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * px -> dp
     *
     * @param context
     * @param px
     * @return
     */
    public static int px2dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getAppBarHeight(Context context) {
        return DimenUtils.dip2px(context, 56) + getStatusBarHeight(context);
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Context context) {

        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    /**
     * 获取底部操作栏高度
     *
     * @param context
     * @return
     */
    public static int getNavBarHeight(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));

    }
}

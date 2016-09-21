package com.rdc.goospet.utils;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.WindowManager;

import com.rdc.goospet.view.widget.FloatingPetView;

/**
 * 悬浮宠物管理类
 * Created by Goo on 2016-9-18.
 */
public class FloatingPetManager {

    /**
     * 悬浮宠物实例
     */
    private static FloatingPetView mFPetView;

    /**
     * 增添及删除悬浮窗
     */
    private static WindowManager mWindowManager;

    /**
     * 参数
     */
    private static WindowManager.LayoutParams mParams;

    /**
     * 创建悬浮宠物
     *
     * @param context
     */
    public static void createPetWindow(Context context) {
        WindowManager windowManager = getWindowManager(context);
        int screenWidth = windowManager.getDefaultDisplay().getWidth();
        int screenHeight = windowManager.getDefaultDisplay().getHeight();
        if (mFPetView == null) {
            mFPetView = new FloatingPetView(context);
            if (mParams == null) {
                mParams = new WindowManager.LayoutParams();
                mParams.type = WindowManager.LayoutParams.TYPE_PHONE;
                mParams.format = PixelFormat.RGBA_8888;
                mParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                mParams.gravity = Gravity.LEFT | Gravity.TOP;
                mParams.width = mFPetView.viewWidth;
                mParams.height = mFPetView.viewHeight;
                mParams.x = screenWidth;
                mParams.y = screenHeight / 2;
            }
            mFPetView.setParams(mParams);
            windowManager.addView(mFPetView, mParams);
        }
    }

    private static WindowManager getWindowManager(Context context) {
        if (mWindowManager == null) {
            mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        }
        return mWindowManager;
    }

    /**
     * 是否有悬浮窗(包括小悬浮窗和大悬浮窗)显示在屏幕上。
     *
     * @return 有悬浮窗显示在桌面上返回true，没有的话返回false。
     */
    public static boolean isFloatingWindowShowing() {
        return mFPetView != null;
    }


}

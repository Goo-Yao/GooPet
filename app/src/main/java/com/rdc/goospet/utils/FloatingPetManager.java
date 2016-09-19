package com.rdc.goospet.utils;

import com.rdc.goospet.view.widget.FloatingPetView;

/**
 * Created by Goo on 2016-9-18.
 */
public class FloatingPetManager {

    private static FloatingPetView mFPetView;
//    public static void createSmallWindow(Context context) {
//        WindowManager windowManager = getWindowManager(context);
//        int screenWidth = windowManager.getDefaultDisplay().getWidth();
//        int screenHeight = windowManager.getDefaultDisplay().getHeight();
//        if (smallWindow == null) {
//            smallWindow = new FloatWindowSmallView(context);
//            if (smallWindowParams == null) {
//                smallWindowParams = new WindowManager.LayoutParams();
//                smallWindowParams.type = WindowManager.LayoutParams.TYPE_PHONE;
//                smallWindowParams.format = PixelFormat.RGBA_8888;
//                smallWindowParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
//                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//                smallWindowParams.gravity = Gravity.LEFT | Gravity.TOP;
//                smallWindowParams.width = FloatWindowSmallView.viewWidth;
//                smallWindowParams.height = FloatWindowSmallView.viewHeight;
//                smallWindowParams.x = screenWidth;
//                smallWindowParams.y = screenHeight / 2;
//            }
//            smallWindow.setParams(smallWindowParams);
//            windowManager.addView(smallWindow, smallWindowParams);
//        }
//    }
//
//    private static WindowManager getWindowManager(Context context) {
//        if (mWindowManager == null) {
//            mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        }
//        return mWindowManager;
//    }

    /**
     * 是否有悬浮窗(包括小悬浮窗和大悬浮窗)显示在屏幕上。
     *
     * @return 有悬浮窗显示在桌面上返回true，没有的话返回false。
     */
    public static boolean isFloatingWindowShowing() {
        return mFPetView != null;
    }


}

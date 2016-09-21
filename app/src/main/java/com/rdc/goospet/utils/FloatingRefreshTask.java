package com.rdc.goospet.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;

import java.util.TimerTask;

/**
 * Created by Goo on 2016-9-18.
 */
public class FloatingRefreshTask extends TimerTask {
    private PackageManager mPackageManager;
    private ActivityManager mActivityManager;
    private Context mContext;
    private Handler handler = new Handler();

    public FloatingRefreshTask(PackageManager packageManager, ActivityManager activityManager, Context context) {
        mPackageManager = packageManager;
        mActivityManager = activityManager;
        mContext = context;
    }

    @Override
    public void run() {
        //当前界面为桌面且没有显示悬浮窗，则显示悬浮窗，否则移除悬浮窗
        if (FloatingUtils.isHome(mActivityManager, mPackageManager) && !FloatingPetManager.isFloatingWindowShowing()) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    FloatingPetManager.createPetWindow(mContext);
                }
            });
        }
        //当前界面不为桌面，而有显示悬浮窗，需要移除悬浮窗
        if (!FloatingUtils.isHome(mActivityManager, mPackageManager) && FloatingPetManager.isFloatingWindowShowing()) {

        }
        //当前界面为桌面，有显示悬浮窗，需要内容更新
        if (FloatingUtils.isHome(mActivityManager, mPackageManager) && FloatingPetManager.isFloatingWindowShowing()) {

        }
    }
}

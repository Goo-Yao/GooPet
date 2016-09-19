package com.rdc.goospet.view.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rdc.goospet.R;
import com.rdc.goospet.utils.FloatingUtils;
import com.rdc.goospet.utils.LogUtils;

/**
 * Created by Goo on 2016-9-18.
 */
public class FloatingPetView extends LinearLayout {
    public static int viewWidth, viewHeight;//宽高
    private static int statusBarHeight;//系统状态栏高度
    private int screenHeight, screenWidth;

    private WindowManager mWindowManager;
    private ImageView mIvPet;

    private float xInView, yInView, xDownInScreen, yDownInScreen, xInScreen, yInScreen;//位置参数
    private WindowManager.LayoutParams mParams;

    private boolean isHide = false;

    public FloatingPetView(Context context) {
        super(context);
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        LayoutInflater.from(context).inflate(R.layout.layout_widget_pet, this);

        View view = findViewById(R.id.ll_pet);
        viewWidth = view.getLayoutParams().width;
        viewHeight = view.getLayoutParams().height;

        mIvPet = (ImageView) findViewById(R.id.iv_pet);
        setPetImg(R.drawable.ic_intro_first_sun);


        //获取屏幕大小
        DisplayMetrics dm = new DisplayMetrics();
        mWindowManager.getDefaultDisplay().getMetrics(dm);
        statusBarHeight = FloatingUtils.getStatusBarHeight(this);
        if (statusBarHeight != -1) {
            screenWidth = dm.widthPixels;
            screenHeight = dm.heightPixels - statusBarHeight;
        } else {
            LogUtils.e("statusBarHeight = -1");
        }

    }

    /**
     * 设置宠物图片
     *
     * @param resid
     */
    private void setPetImg(int resid) {
        mIvPet.setBackgroundResource(resid);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录必要数据,纵坐标的值要减去状态栏高度
                // 动画逻辑处理 - 停止正在播放的动画，触发拎起动画
                xInView = event.getX();
                yInView = event.getY();
                xDownInScreen = event.getRawX();
                yDownInScreen = event.getRawY() - FloatingUtils.getStatusBarHeight(this);
                xInScreen = event.getRawX();
                yInScreen = event.getRawY() - FloatingUtils.getStatusBarHeight(this);
                break;
            case MotionEvent.ACTION_MOVE:
                xInScreen = event.getRawX();
                yInScreen = event.getRawY() - FloatingUtils.getStatusBarHeight(this);
                // 手指移动的时候更新小悬浮窗的位置
                updateViewPosition();
                break;
            case MotionEvent.ACTION_UP:
                if (xDownInScreen == xInScreen && yDownInScreen == yInScreen) {
                    LogUtils.e("单击事件");
                }
                break;
        }
        return true;
    }

    /**
     * 更新小悬浮窗在屏幕中的位置。
     */
    private void updateViewPosition() {
        mParams.x = (int) (xInScreen - xInView);
        mParams.y = (int) (yInScreen - yInView);
        mWindowManager.updateViewLayout(this, mParams);
    }
}

package com.rdc.goospet.view.widget;

import android.animation.ValueAnimator;
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

import java.util.Random;

/**
 * Created by Goo on 2016-9-18.
 */
public class FloatingPetView extends LinearLayout {
    /**
     * 窗体宽高
     */
    public static int viewWidth, viewHeight;

    /**
     * 系统状态栏高度
     */
    private static int statusBarHeight;

    /**
     * 屏幕宽高
     */
    private int screenHeight, screenWidth;

    /**
     * 窗体管理
     */
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mParams;

    /**
     * 悬浮窗Iv
     */
    private ImageView mIvPet;

    /**
     * 位置参数
     */
    private float xInView, yInView, xDownInScreen, yDownInScreen, xInScreen, yInScreen;

    /**
     * 是否按住状态
     */
    private boolean isPressed = false;

    /**
     * 是否需要隐藏
     */
    private boolean isNeedHide = false;

    /**
     * 动画 - 按住状态
     */
    private ValueAnimator mTouchedAnim;

    /**
     * 动画 - 移动状态
     */
    private ValueAnimator mMovingAnim;


    public FloatingPetView(Context context) {
        super(context);
        initView(context);
    }

    /**
     * 初始化视图
     *
     * @param context
     */
    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_widget_pet, this);
        findAllViewById();
        initViewParams(context);
        defaultPetStatus();
    }

    private void findAllViewById() {
        mIvPet = (ImageView) findViewById(R.id.iv_pet);
    }

    /**
     * 初始化窗体宽高参数
     */
    private void initViewParams(Context context) {
        View view = findViewById(R.id.ll_pet);
        viewWidth = view.getLayoutParams().width;
        viewHeight = view.getLayoutParams().height;
        DisplayMetrics dm = new DisplayMetrics();
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
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
     * 设置宠物样式
     *
     * @param resid
     */
    private void setPetImg(int resid) {
        mIvPet.setBackgroundResource(resid);
    }

    /**
     * 将小悬浮窗的参数传入，用于更新小悬浮窗的位置。
     *
     * @param params 小悬浮窗的参数
     */
    public void setParams(WindowManager.LayoutParams params) {
        mParams = params;
    }

    /**
     * 处理控件触摸事件
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isPressed = true;
                refreshParamsForDown(event);
                updatePetState();
                break;
            case MotionEvent.ACTION_MOVE:
                isNeedHide = false;
                refreshParamsForMove(event);
                updatePetPosition();
                updatePetState();
                break;
            case MotionEvent.ACTION_UP:
                isPressed = false;

                if (xDownInScreen == xInScreen && yDownInScreen == yInScreen) {
                    //触摸坐标不变，即点击事件
                    updatePetState();
                } else if (xInScreen < screenWidth / 8) {  //当在这个位置放手时宠物贴边隐藏
                    hideLeft();
                } else if (xInScreen > screenWidth * 7 / 8) {
                    hideRight();
                    break;
                } else {
                    updatePetState();
                }
        }
        return true;
    }

    /**
     * 右边贴边
     */
    private void hideRight() {
        setPetImg(R.drawable.ic_pet_hide_right);
    }

    /**
     * 左边贴边
     */
    private void hideLeft() {
        setPetImg(R.drawable.ic_pet_hide_left);
    }

    /**
     * 更新宠物状态
     */
    private void updatePetState() {
        if (isPressed) {
            //按住状态
            touchPetStatus();
        } else if (isNeedHide) {
            //没有按住，需要贴边，贴边即可
        } else {
            //没有按住，也不需要贴边，默认状态即可
            defaultPetStatus();
        }
    }

    private void defaultPetStatus() {
        switch (new Random().nextInt(5) + 3) {
            case 3:
                setPetImg(R.drawable.ic_face_03);
                break;
            case 4:
                setPetImg(R.drawable.ic_face_04);
                break;
            case 5:
                setPetImg(R.drawable.ic_face_05);
                break;
            case 6:
                setPetImg(R.drawable.ic_face_06);
                break;
            case 7:
                setPetImg(R.drawable.ic_face_07);
                break;
        }
    }

    /**
     * 按住（拎起）状态，随机更换表情
     */
    private void touchPetStatus() {
        setPetImg(R.drawable.ic_face_02);
    }

    /**
     * 更新参数 - 移动时刻
     *
     * @param event
     */
    private void refreshParamsForMove(MotionEvent event) {
        xInScreen = event.getRawX();
        yInScreen = event.getRawY() - FloatingUtils.getStatusBarHeight(this);
    }

    /**
     * 更新参数 - 按下时刻
     *
     * @param event
     */
    private void refreshParamsForDown(MotionEvent event) {
        xInView = event.getX();
        yInView = event.getY();
        xDownInScreen = event.getRawX();
        yDownInScreen = event.getRawY() - FloatingUtils.getStatusBarHeight(this);
        refreshParamsForMove(event);
    }

    /**
     * 更新小悬浮窗在屏幕中的位置。
     */
    private void updatePetPosition() {
        mParams.x = (int) (xInScreen - xInView);
        mParams.y = (int) (yInScreen - yInView);
        mWindowManager.updateViewLayout(this, mParams);
    }
}

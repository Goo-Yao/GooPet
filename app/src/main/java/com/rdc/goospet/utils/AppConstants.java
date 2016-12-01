package com.rdc.goospet.utils;

import com.rdc.goospet.R;

/**
 * Created by Goo on 2016-8-28.
 * 常量管理类
 */
public class AppConstants {
    public static final int OUT_PENDING_TRANSITION = 10;
    public static final int OPEN_PENDING_TRANSITION = 20;

    public static final int INTRO_TAG_FIRST = 1234;
    public static final int INTRO_TAG_SECOND = 2345;
    public static final int INTRO_TAG_THIRD = 3456;
    public static final int INTRO_TAG_FOURTH = 4567;

    public static final float PARALLAX_COEFFICIENT = 1.2f;//视差系数
    public static final float DISTANCE_COEFFICIENT = 0.8f;//距离系数

    public static final int INTRO_ANIMATION_DURATION = 500;//动画时间
    public static final int INTRO_ANIMATION_OFFSET = 50;//动画间隔

    public static final int INTRO_START_COLOR = R.color.colorIntroLightPrimary;
    public static final int INTRO_END_COLOR = R.color.lightOrange;

    public static final String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    public static String USER_NAME = null;

    //petId
    public static final int PET_OWL = 1221;
    public static final int PET_PIG = 1222;
    public static final int PET_COW = 1223;
    public static final int PET_BIRD = 1224;

}

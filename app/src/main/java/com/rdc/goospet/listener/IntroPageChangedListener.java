package com.rdc.goospet.listener;

import android.animation.ArgbEvaluator;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.widget.TextSwitcher;

import com.rdc.goospet.R;
import com.rdc.goospet.utils.AppConstants;

/**
 * Created by Goo on 2016-9-2.
 */
public class IntroPageChangedListener implements ViewPager.OnPageChangeListener {
    private ArgbEvaluator mColorEvaluator;

    private int mPageWidth, mTotalScrollWidth;

    private int mGuideStartBackgroundColor, mGuideEndBackgroundColor;

    private ViewPager mVp;

    private TextSwitcher mTSwitcher;
    private String[] mIntroTips;

    public IntroPageChangedListener(ViewPager vp, TextSwitcher tSwitcher, int pageWidth, int pageNum, Resources resources) {
        mVp = vp;
        mTSwitcher = tSwitcher;
        mColorEvaluator = new ArgbEvaluator();

        mPageWidth = pageWidth;
        mTotalScrollWidth = mPageWidth * pageNum;

        mGuideStartBackgroundColor = resources.getColor(AppConstants.INTRO_START_COLOR);
        mGuideEndBackgroundColor = resources.getColor(AppConstants.INTRO_END_COLOR);

        mIntroTips = resources.getStringArray(R.array.array_intro_tips);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        float ratio = (mPageWidth * position + positionOffsetPixels) / (float) mTotalScrollWidth;
        Integer color = (Integer) mColorEvaluator.evaluate(ratio, mGuideStartBackgroundColor, mGuideEndBackgroundColor);
        mVp.setBackgroundColor(color);
    }

    @Override
    public void onPageSelected(int position) {

        mTSwitcher.setText(mIntroTips[position]);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}

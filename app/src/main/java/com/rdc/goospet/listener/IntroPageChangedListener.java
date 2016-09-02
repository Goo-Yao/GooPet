package com.rdc.goospet.listener;

import android.animation.ArgbEvaluator;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;

import com.rdc.goospet.R;

/**
 * Created by Goo on 2016-9-2.
 */
public class IntroPageChangedListener implements ViewPager.OnPageChangeListener {
    private ArgbEvaluator mColorEvaluator;

    private int mPageWidth, mTotalScrollWidth;

    private int mGuideStartBackgroundColor, mGuideEndBackgroundColor;

    private ViewPager mVp;

    public IntroPageChangedListener(ViewPager vp, int pageWidth, int pageNum, Resources resources) {
        mVp = vp;
        mColorEvaluator = new ArgbEvaluator();

        mPageWidth = pageWidth;
        mTotalScrollWidth = mPageWidth * pageNum;

        mGuideStartBackgroundColor = resources.getColor(R.color.colorPrimary);
        mGuideEndBackgroundColor = resources.getColor(R.color.colorLightPrimary);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        float ratio = (mPageWidth * position + positionOffsetPixels) / (float) mTotalScrollWidth;
        Integer color = (Integer) mColorEvaluator.evaluate(ratio, mGuideStartBackgroundColor, mGuideEndBackgroundColor);
        mVp.setBackgroundColor(color);
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}

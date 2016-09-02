package com.rdc.goospet.utils;

import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by Goo on 2016-9-1.
 */
public class ParallaxTransformer implements ViewPager.PageTransformer {

    private float mParallaxCoefficient;
    private float mDistanceCoefficient;
    private SparseArray<int[]> mLayoutViewIdsMap = null;

    public ParallaxTransformer(float parallaxCoefficient, float distanceCoefficient, SparseArray<int[]> layoutViewIdsMap) {
        mParallaxCoefficient = parallaxCoefficient;
        mDistanceCoefficient = distanceCoefficient;
        mLayoutViewIdsMap = layoutViewIdsMap;
    }

    @Override
    public void transformPage(View page, float position) {
        float scrollXOffset = page.getWidth() * mParallaxCoefficient;
        //简单实现：对view遍历，递增视觉差系数
        if (mLayoutViewIdsMap != null) {
            int[] layer = mLayoutViewIdsMap.get((int) page.getTag());
            for (int id : layer) {
                View view = page.findViewById(id);
                if (view != null) {
                    view.setTranslationX(scrollXOffset * position);
                }
                scrollXOffset *= mDistanceCoefficient;
            }
        }
    }
}

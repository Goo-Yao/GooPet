package com.rdc.goospet.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.rdc.goospet.R;
import com.rdc.goospet.base.BaseIntroFragment;

/**
 * Created by Goo on 2016-9-1.
 */
public class IntroFirstFragment extends BaseIntroFragment {

    private static final int ANIMATION_DURATION = 500;
    private static final int ANIMATION_OFFSET = 200;

    private int[] mAnimationViewIds = {
            R.id.iv_intro_1, R.id.iv_intro_2, R.id.iv_intro_3,
            R.id.iv_intro_4, R.id.iv_intro_6, R.id.iv_intro_7,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAnim(view);
    }

    /**
     * 为intro元素添加动画
     *
     * @param view
     */
    private void initAnim(View view) {
        for (int i = 0; i < mAnimationViewIds.length; i++) {
            Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.splash_intro_items);
            animation.setDuration(ANIMATION_DURATION);
            animation.setStartOffset(ANIMATION_OFFSET * i);
            view.findViewById(mAnimationViewIds[i]).startAnimation(animation);
        }
    }

    @Override
    public int[] getChildViewIds() {
        return new int[]{
                R.id.iv_intro_1
        };
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_intro_first;
    }
}

package com.rdc.goospet.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rdc.goospet.base.BaseIntroFragment;

import java.util.List;

/**
 * Created by Goo on 2016-8-31.
 */
public class IntroFragmentAdapter extends FragmentStatePagerAdapter {

    private List<BaseIntroFragment> mFragments = null;

    public IntroFragmentAdapter(FragmentManager fm, List<BaseIntroFragment> fragments) {
        super(fm);
        mFragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        if (mFragments != null) {
            return mFragments.get(position);
        }
        return null;

    }

    @Override
    public int getCount() {
        if (mFragments != null) {
            return mFragments.size();
        }
        return 0;

    }
}

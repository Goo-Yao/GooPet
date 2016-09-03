package com.rdc.goospet.base;

import android.support.v4.app.Fragment;

/**
 * 懒加载、IntroFragment
 * Created by Goo on 2016-9-1.
 */
public abstract class BaseIntroFragment extends Fragment {

    public abstract int getViewTag();

    public abstract int[] getChildViewIds();
}

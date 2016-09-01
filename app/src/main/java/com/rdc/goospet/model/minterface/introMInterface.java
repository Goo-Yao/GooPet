package com.rdc.goospet.model.minterface;

import android.util.SparseArray;

import com.rdc.goospet.base.BaseIntroFragment;

import java.util.List;

/**
 * Created by Goo on 2016-8-31.
 */
public interface IntroMInterface {

    List<BaseIntroFragment> getIntroFragemnts();

    SparseArray<int[]> getLayoutViewIdsMap();
}

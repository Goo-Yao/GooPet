package com.rdc.goospet.model;

import android.util.SparseArray;

import com.rdc.goospet.base.BaseIntroFragment;
import com.rdc.goospet.model.minterface.IntroMInterface;
import com.rdc.goospet.view.fragment.IntroFirstFragment;
import com.rdc.goospet.view.fragment.IntroFourthFragment;
import com.rdc.goospet.view.fragment.IntroSecondFragment;
import com.rdc.goospet.view.fragment.IntroThirdFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goo on 2016-8-31.
 */
public class IntroModel implements IntroMInterface {
    private static List<BaseIntroFragment> list = null;
    private static SparseArray<int[]> layoutViewIdsMap = null;

    @Override
    public List<BaseIntroFragment> getIntroFragemnts() {
        if (list == null) {
            list = new ArrayList<>();
            list.add(new IntroFirstFragment());
            list.add(new IntroSecondFragment());
            list.add(new IntroThirdFragment());
            list.add(new IntroFourthFragment());
        }
        return list;
    }

    @Override
    public SparseArray<int[]> getLayoutViewIdsMap() {
        if (list != null && layoutViewIdsMap == null) {
            layoutViewIdsMap = new SparseArray<int[]>();
            for (int i = 0; i < list.size(); i++) {
                layoutViewIdsMap.put(list.get(i).getViewTag(), list.get(i).getChildViewIds());
            }
            return layoutViewIdsMap;
        }
        return null;
    }
}

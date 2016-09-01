package com.rdc.goospet.presenter;

import android.support.v4.app.FragmentManager;

import com.rdc.goospet.adapter.IntroFragmentAdapter;
import com.rdc.goospet.base.BasePresenter;
import com.rdc.goospet.model.IntroModel;
import com.rdc.goospet.model.minterface.IntroMInterface;
import com.rdc.goospet.utils.ParallaxTransformer;
import com.rdc.goospet.view.vinterface.IntroVInterface;

/**
 * Created by Goo on 2016-8-31.
 */
public class IntroPresenter extends BasePresenter<IntroVInterface> {

    public static final float PARALLAX_COEFFICIENT = 1.2f;//视差系数
    public static final float DISTANCE_COEFFICIENT = 0.5f;//

    private IntroMInterface mModel;


    public IntroPresenter(IntroVInterface viewInterface) {
        super(viewInterface);
        mModel = new IntroModel();
    }

    /**
     * 获得 introAdapter
     *
     * @param fm
     * @return
     */
    public IntroFragmentAdapter getPagerAdapter(FragmentManager fm) {
        return new IntroFragmentAdapter(fm, mModel.getIntroFragemnts());
    }

    public ParallaxTransformer getTransformer() {
        return new ParallaxTransformer(PARALLAX_COEFFICIENT, DISTANCE_COEFFICIENT, mModel.getLayoutViewIdsMap());
    }
}

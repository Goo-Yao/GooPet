package com.rdc.goospet.presenter;

import android.support.v4.app.FragmentManager;

import com.rdc.goospet.adapter.IntroFragmentAdapter;
import com.rdc.goospet.base.BasePresenter;
import com.rdc.goospet.model.IntroModel;
import com.rdc.goospet.model.minterface.IntroMInterface;
import com.rdc.goospet.view.vinterface.IntroVInterface;

/**
 * Created by Goo on 2016-8-31.
 */
public class IntroPresenter extends BasePresenter<IntroVInterface> {

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


}

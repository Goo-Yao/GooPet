package com.rdc.goospet.view.activity;

import com.rdc.goospet.R;
import com.rdc.goospet.base.BaseSwipeBackActivity;
import com.rdc.goospet.presenter.SettingPresenter;
import com.rdc.goospet.view.vinterface.SettingVInterface;

public class SettingActivity extends BaseSwipeBackActivity<SettingVInterface, SettingPresenter> implements SettingVInterface {


    @Override
    protected SettingPresenter createPresenter() {
        return new SettingPresenter(this);
    }

    @Override
    protected int setContentViewById() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initAttributes() {

    }

    @Override
    protected void initView() {
        showToolbarAndShowNavigation("设置");
    }

    @Override
    protected void findAllViewById() {

    }
}

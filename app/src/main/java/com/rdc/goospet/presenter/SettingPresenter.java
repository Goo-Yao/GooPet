package com.rdc.goospet.presenter;

import com.rdc.goospet.base.BasePresenter;
import com.rdc.goospet.model.SettingModel;
import com.rdc.goospet.model.minterface.SettingMInterface;
import com.rdc.goospet.view.vinterface.SettingVInterface;

/**
 * Created by Goo on 2016-10-24.
 */

public class SettingPresenter extends BasePresenter<SettingVInterface> {

    private SettingMInterface mModel;

    public SettingPresenter(SettingVInterface viewInterface) {
        super(viewInterface);
        mModel = new SettingModel();
    }
}

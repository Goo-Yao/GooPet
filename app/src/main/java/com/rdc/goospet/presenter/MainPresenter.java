package com.rdc.goospet.presenter;

import com.rdc.goospet.base.BasePresenter;
import com.rdc.goospet.model.MainModel;
import com.rdc.goospet.model.minterface.MainMInterface;
import com.rdc.goospet.view.vinterface.MainVInterface;

/**
 * Created by Goo on 2016-9-18.
 */
public class MainPresenter extends BasePresenter<MainVInterface> {

    private MainMInterface model;

    public MainPresenter(MainVInterface viewInterface) {
        super(viewInterface);
        model = new MainModel();
    }
}

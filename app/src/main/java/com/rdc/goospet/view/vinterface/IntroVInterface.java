package com.rdc.goospet.view.vinterface;

/**
 * Created by Goo on 2016-8-31.
 */
public interface IntroVInterface {

    void showProgressDialog();

    void dismissDialog();

    void registerSuccess();

    void loginSuccess();

    void errorEmptyInfo();

    void errorPswNotEqual();

    void errorEmailInvalid();

    void errorUserNameRepeat();

    void errorEmailRepeat();

    void errorNetWork();

}

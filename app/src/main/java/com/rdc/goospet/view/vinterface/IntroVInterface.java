package com.rdc.goospet.view.vinterface;

/**
 * Created by Goo on 2016-8-31.
 */
public interface IntroVInterface {

    void showProgressDialog();

    void dismissDialog();

    void registerSuccess(String userName);

    void loginSuccess(String userName);

    void errorLoginFail();

    void errorEmptyInfo();

    void errorPswNotEqual();

    void errorEmailInvalid();

    void errorUserNameRepeat();

    void errorEmailRepeat();

    void errorNetWork();

}

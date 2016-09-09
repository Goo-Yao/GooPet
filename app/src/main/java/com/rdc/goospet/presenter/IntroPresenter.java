package com.rdc.goospet.presenter;

import android.support.v4.app.FragmentManager;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SignUpCallback;
import com.rdc.goospet.adapter.IntroFragmentAdapter;
import com.rdc.goospet.base.BasePresenter;
import com.rdc.goospet.model.IntroModel;
import com.rdc.goospet.model.minterface.IntroMInterface;
import com.rdc.goospet.utils.AVOSUtils;
import com.rdc.goospet.utils.AppConstants;
import com.rdc.goospet.utils.ParallaxTransformer;
import com.rdc.goospet.view.vinterface.IntroVInterface;

import java.util.regex.Pattern;

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

    public ParallaxTransformer getTransformer() {
        return new ParallaxTransformer(AppConstants.PARALLAX_COEFFICIENT, AppConstants.DISTANCE_COEFFICIENT, mModel.getLayoutViewIdsMap());
    }

    public void login(final String userName, String psw) {
        if (userName.isEmpty() || psw.isEmpty()) {
            view.errorEmptyInfo();
        } else {
            view.showProgressDialog();
            AVUser.logInInBackground(userName, psw, new LogInCallback<AVUser>() {
                @Override
                public void done(AVUser avUser, AVException e) {
                    view.dismissDialog();
                    if (avUser != null) {
                        view.loginSuccess(avUser.getUsername());
                    } else {
                        view.errorLoginFail();
                    }
                }
            });
        }

    }

    public void register(final String userName, String email, String psw, String pswAgain) {
        if (userName.isEmpty() || email.isEmpty() || psw.isEmpty() || pswAgain.isEmpty()) {
            view.errorEmptyInfo();
        } else if (!psw.equals(pswAgain)) {
            view.errorPswNotEqual();
        } else if (!Pattern.compile(AppConstants.REGEX_EMAIL).matcher(email).find()) {
            view.errorEmailInvalid();
        } else {
            view.showProgressDialog();
            AVOSUtils.signUp(userName, psw, email, new SignUpCallback() {
                @Override
                public void done(AVException e) {
                    view.dismissDialog();
                    if (e == null) {
                        view.registerSuccess(userName);
                    } else {
                        switch (e.getCode()) {
                            case 202:
                                view.errorUserNameRepeat();
                                break;
                            case 203:
                                view.errorEmailRepeat();
                                break;
                            default:
                                view.errorNetWork();
                                break;
                        }
                    }
                }
            });
        }

    }
}

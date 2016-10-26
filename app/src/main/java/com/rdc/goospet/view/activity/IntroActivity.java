package com.rdc.goospet.view.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.MaterialEditText;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.rdc.goospet.R;
import com.rdc.goospet.adapter.IntroFragmentAdapter;
import com.rdc.goospet.base.BaseActivity;
import com.rdc.goospet.listener.IntroPageChangedListener;
import com.rdc.goospet.presenter.IntroPresenter;
import com.rdc.goospet.utils.AppConstants;
import com.rdc.goospet.utils.DialogUtils;
import com.rdc.goospet.utils.ToastUtil;
import com.rdc.goospet.view.vinterface.IntroVInterface;
import com.rdc.goospet.view.widget.CirclePageIndicator;

/**
 * Created by Goo on 2016-8-28.
 * 介绍界面（界面设计暂定）
 */
public class IntroActivity extends BaseActivity<IntroVInterface, IntroPresenter> implements IntroVInterface, View.OnClickListener {

    private ViewPager mVpIntro;
    private CirclePageIndicator mIndicator;
    private IntroFragmentAdapter mPagerAdapter;

    private TextView mTvIntroLogin, mTvIntroRegister;
    private TextView mTvLogin, mTvSocialLogin, mTvRegister;
    private TextSwitcher mTSwitcher;

    private EditText mEtAccount, mEtPsw, mEtRAccount, mEtREmail, mEtRPsw, mEtRPswAgain;

    private AlertDialog mLoginDialog, mRegisterDialog = null;


    @Override
    protected IntroPresenter createPresenter() {
        return new IntroPresenter(this);
    }


    @Override
    protected int setContentViewById() {
        return R.layout.activity_intro;
    }

    @Override
    protected void initAttributes() {

    }

    @Override
    protected void initView() {
        findAllViewById();
        setAllClickListener();
        initVp();
        initIndicator();
    }

    private void initVp() {
        mPagerAdapter = mPresenter.getPagerAdapter(getSupportFragmentManager());
        mVpIntro.setOffscreenPageLimit(0);
        mVpIntro.setAdapter(mPagerAdapter);
        mVpIntro.setPageTransformer(true, mPresenter.getTransformer());
    }

    private void initIndicator() {
        mIndicator.setViewPager(mVpIntro);
        mIndicator.setPageColor(getResources().getColor(R.color.standardWhite));
        mIndicator.setFillColor(getResources().getColor(R.color.colorAccent));
        mIndicator.setOnPageChangeListener(new IntroPageChangedListener(mVpIntro, mTSwitcher, getWindowManager().getDefaultDisplay().getWidth(), mPagerAdapter.getCount(), getResources()));
    }

    private void setAllClickListener() {
        mTvIntroLogin.setOnClickListener(this);
        mTvIntroRegister.setOnClickListener(this);
    }

    @Override
    protected void findAllViewById() {
        mVpIntro = $(R.id.vp_intro);
        mIndicator = $(R.id.cpi);
        mTvIntroLogin = $(R.id.tv_intro_login);
        mTvIntroRegister = $(R.id.tv_intro_register);
        mTSwitcher = $(R.id.ts_intro);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_intro_login:
                showLoginDialog();
                break;
            case R.id.tv_intro_register:
                showRegisterDialog();
                break;
            case R.id.tv_login:
                dismissDialog();
                mPresenter.login(mEtAccount.getText().toString(), mEtPsw.getText().toString());
                break;
            case R.id.tv_social_login:
                break;
            case R.id.tv_register:
                mPresenter.register(mEtRAccount.getText().toString(), mEtREmail.getText().toString(), mEtRPsw.getText().toString(), mEtRPswAgain.getText().toString());
                break;
        }
    }


    private void showLoginDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View loginDialog = inflater.inflate(R.layout.layout_dialog_login, (ViewGroup) findViewById(R.id.ll_dialog));

        mEtAccount = (MaterialEditText) loginDialog.findViewById(R.id.et_account);
        mEtPsw = (MaterialEditText) loginDialog.findViewById(R.id.et_psw);
        mTvLogin = (TextView) loginDialog.findViewById(R.id.tv_login);
        mTvSocialLogin = (TextView) loginDialog.findViewById(R.id.tv_social_login);
        mTvLogin.setOnClickListener(this);
        mTvSocialLogin.setOnClickListener(this);

        mLoginDialog = DialogUtils.showCoustomDialog(this, loginDialog, "登录");

    }

    private void showRegisterDialog() {

        LayoutInflater inflater = getLayoutInflater();
        View registerDialog = inflater.inflate(R.layout.layout_dialog_register, (ViewGroup) findViewById(R.id.ll_dialog));

        mTvRegister = (TextView) registerDialog.findViewById(R.id.tv_register);
        mEtRAccount = (EditText) registerDialog.findViewById(R.id.et_register_account);
        mEtREmail = (EditText) registerDialog.findViewById(R.id.et_register_email);
        mEtRPsw = (EditText) registerDialog.findViewById(R.id.et_register_psw);
        mEtRPswAgain = (EditText) registerDialog.findViewById(R.id.et_register_psw_again);
        mTvRegister.setOnClickListener(this);

        mRegisterDialog = DialogUtils.showCoustomDialog(this, registerDialog, "注册");
    }

    @Override
    public void showProgressDialog() {
        super.showProgressDialog(getString(R.string.tips_net_working));
    }

    @Override
    public void dismissDialog() {
        super.dismissProgressDialog();
    }

    @Override
    public void registerSuccess(String userName) {
        ToastUtil.showToast(this, getString(R.string.tips_register_success));
        EnterMain(userName);

    }

    @Override
    public void loginSuccess(String userName) {
        EnterMain(userName);
    }

    @Override
    public void errorLoginFail() {
        ToastUtil.showToast(this, getString(R.string.tips_error_login));
    }

    @Override
    public void errorEmptyInfo() {
        ToastUtil.showToast(this, getString(R.string.error_empty_info));
    }

    @Override
    public void errorPswNotEqual() {
        ToastUtil.showToast(this, getString(R.string.error_psw_not_equal));
    }

    @Override
    public void errorEmailInvalid() {
        ToastUtil.showToast(this, getString(R.string.error_email_invalid));
    }

    @Override
    public void errorUserNameRepeat() {
        ToastUtil.showToast(this, getString(R.string.error_username_repeat));

    }

    @Override
    public void errorEmailRepeat() {
        ToastUtil.showToast(this, getString(R.string.error_email_repeat));
    }

    @Override
    public void errorNetWork() {
        ToastUtil.showToast(this, getString(R.string.error_network));
    }

    /**
     * 进入主界面
     *
     * @param userName
     */
    private void EnterMain(String userName) {
        AppConstants.USER_NAME = userName;
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivityWithAnim(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        if (mLoginDialog != null) {
            mLoginDialog.dismiss();
        }
        if (mRegisterDialog != null) {
            mRegisterDialog.dismiss();
        }
        super.onDestroy();
    }
}

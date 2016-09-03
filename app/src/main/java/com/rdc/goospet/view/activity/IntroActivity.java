package com.rdc.goospet.view.activity;

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
import com.rdc.goospet.view.vinterface.IntroVInterface;
import com.rdc.goospet.view.widget.CirclePageIndicator;

/**
 * Created by Goo on 2016-8-28.
 */
public class IntroActivity extends BaseActivity<IntroVInterface, IntroPresenter> implements IntroVInterface, View.OnClickListener {

    private ViewPager mVpIntro;
    private CirclePageIndicator mIndicator;
    private IntroFragmentAdapter mPagerAdapter;

    private TextView mTvIntroLogin, mTvIntroRegister, mTvLogin, mTvSocialLogin;
    private TextSwitcher mTSwitcher;

    private EditText mEtAccount, mEtPsw;


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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录");
        builder.setView(loginDialog);
        builder.show();


    }

    private void showRegisterDialog() {

    }
}

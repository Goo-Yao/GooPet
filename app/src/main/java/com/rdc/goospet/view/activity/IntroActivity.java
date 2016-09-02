package com.rdc.goospet.view.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
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
    private TextView mTvLogin, mTvRegister;


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
        mPagerAdapter = mPresenter.getPagerAdapter(getSupportFragmentManager());

        mVpIntro.setAdapter(mPagerAdapter);
        mVpIntro.setPageTransformer(true, mPresenter.getTransformer());

        mIndicator.setViewPager(mVpIntro);
        mIndicator.setPageColor(getResources().getColor(R.color.standardWhite));
        mIndicator.setFillColor(getResources().getColor(R.color.colorAccent));
        mIndicator.setOnPageChangeListener(new IntroPageChangedListener(mVpIntro, getWindowManager().getDefaultDisplay().getWidth(), mPagerAdapter.getCount(), getResources()));
    }

    private void setAllClickListener() {
        mTvLogin.setOnClickListener(this);
        mTvRegister.setOnClickListener(this);
    }

    @Override
    protected void findAllViewById() {
        mVpIntro = $(R.id.vp_intro);
        mIndicator = $(R.id.cpi);
        mTvLogin = $(R.id.tv_login);
        mTvRegister = $(R.id.tv_register);
    }

    @Override
    public void onClick(View view) {

    }
}

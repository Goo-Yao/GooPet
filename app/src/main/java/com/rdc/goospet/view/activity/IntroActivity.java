package com.rdc.goospet.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;

import com.rdc.goospet.R;
import com.rdc.goospet.adapter.IntroFragmentAdapter;
import com.rdc.goospet.base.BaseActivity;
import com.rdc.goospet.presenter.IntroPresenter;
import com.rdc.goospet.view.vinterface.IntroVInterface;
import com.rdc.goospet.view.widget.CirclePageIndicator;

/**
 * Created by Goo on 2016-8-28.
 */
public class IntroActivity extends BaseActivity<IntroVInterface, IntroPresenter> implements IntroVInterface {

    private ViewPager mVpIntro;
    private CirclePageIndicator mIndicator;
    private IntroFragmentAdapter mPagerAdapter;

    @Override

    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

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
        mPagerAdapter = mPresenter.getPagerAdapter(getSupportFragmentManager());
    }

    @Override
    protected void initView() {
        findAllViewById();

        mVpIntro.setAdapter(mPagerAdapter);
        mIndicator.setViewPager(mVpIntro);

        mVpIntro.setPageTransformer(true, mPresenter.getTransformer());
    }

    @Override
    protected void findAllViewById() {
        mVpIntro = $(R.id.vp_intro);
        mIndicator = $(R.id.cpi);
    }

}

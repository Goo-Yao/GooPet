package com.rdc.goospet.view.activity;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.rdc.goospet.R;
import com.rdc.goospet.adapter.RVMainAdapter;
import com.rdc.goospet.base.BaseActivity;
import com.rdc.goospet.listener.HidingScrollListener;
import com.rdc.goospet.presenter.MainPresenter;
import com.rdc.goospet.service.FloatingPetService;
import com.rdc.goospet.utils.DimenUtils;
import com.rdc.goospet.view.vinterface.MainVInterface;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity<MainVInterface, MainPresenter> implements MainVInterface, View.OnClickListener {


    private RecyclerView mRvMain;
    private FloatingActionButton mFABSetting;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int setContentViewById() {
        return R.layout.activity_main;
    }

    @Override
    protected void initAttributes() {

    }

    @Override
    protected void initView() {
        findAllViewById();
        initRv();
        mFABSetting.setOnClickListener(this);
    }

    /**
     * 加载R
     */
    private void initRv() {
        RVMainAdapter rvAdapter = mPresenter.getRVAdapter(this);
        mRvMain.setLayoutManager(new LinearLayoutManager(this));
        mRvMain.setAdapter(rvAdapter);
        mRvMain.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideFAB();
            }

            @Override
            public void onShow() {
                showFAB();
            }
        });
        ItemTouchHelper itemHelper = mPresenter.getItemTouchHelper(rvAdapter);
        itemHelper.attachToRecyclerView(mRvMain);
    }


    /**
     * 显示悬浮按钮
     */
    private void showFAB() {
        mFABSetting.animate().translationY(0).setInterpolator(new DecelerateInterpolator(1)).start();
    }

    /**
     * 隐藏悬浮按钮
     */
    private void hideFAB() {
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) mFABSetting.getLayoutParams();
        int fabBottomMargin = lp.bottomMargin;
        mFABSetting.animate().translationY(mFABSetting.getHeight() + fabBottomMargin + DimenUtils.getNavBarHeight(this) + DimenUtils.getStatusBarHeight(this)).
                setInterpolator(new AccelerateInterpolator(2)).start();
    }


    @Override
    protected void findAllViewById() {
        mRvMain = $(R.id.rv_main);
        mFABSetting = $(R.id.fab_setting);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rv_main:
                break;
            case R.id.fab_setting:
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivityWithAnim(intent);
                break;
//            case R.id.btn_show:
//                //启动悬浮pet
//                Intent intent = new Intent(MainActivity.this, FloatingPetService.class);
//                startService(intent);
//                Intent home = new Intent(Intent.ACTION_MAIN);
//                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                home.addCategory(Intent.CATEGORY_HOME);
//                startActivity(home);
//                break;
        }
    }

    @Override
    protected void onDestroy() {
//        stopService();
        super.onDestroy();
    }

    @Override
    public void launchDesktopPet() {
        //启动悬浮pet
        Intent intent = new Intent(MainActivity.this, FloatingPetService.class);
        startService(intent);
        Intent home = new Intent(Intent.ACTION_MAIN);
        home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        home.addCategory(Intent.CATEGORY_HOME);
        startActivity(home);
    }
}
